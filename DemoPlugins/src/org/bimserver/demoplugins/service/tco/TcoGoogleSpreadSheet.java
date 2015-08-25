package org.bimserver.demoplugins.service.tco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.gdata.client.spreadsheet.CellQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.client.spreadsheet.WorksheetQuery;
import com.google.gdata.data.Link;
import com.google.gdata.data.batch.BatchOperationType;
import com.google.gdata.data.batch.BatchStatus;
import com.google.gdata.data.batch.BatchUtils;
import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.ServiceException;

public class TcoGoogleSpreadSheet {
	private static final List<String> SCOPES = Arrays.asList("https://spreadsheets.google.com/feeds");
	private final Map<String, Map<CellKey, CellValue>> updatedCells = new HashMap<>();
	private String clientId;
	private String clientSecret;
	private String redirectUrl;
	private static final String SPREADSHEET_FEED_URL = "https://spreadsheets.google.com/feeds/spreadsheets/private/full";

	public TcoGoogleSpreadSheet(String clientId, String clientSecret, String redirectUrl) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.redirectUrl = redirectUrl;
	}

	public void commit() throws IOException, ServiceException {
		SpreadsheetService service = new SpreadsheetService("MySpreadsheetIntegration");
		service.setProtocolVersion(SpreadsheetService.Versions.V3);

		service.setOAuth2Credentials(getCredentials());

		SpreadsheetQuery spreadsheetQuery = new SpreadsheetQuery(new URL(SPREADSHEET_FEED_URL));
		spreadsheetQuery.setTitleExact(true);
		spreadsheetQuery.setTitleQuery("PROFICIENT TCO tool_v0.7");

		SpreadsheetFeed sheetsFeed = service.query(spreadsheetQuery, SpreadsheetFeed.class);
		List<SpreadsheetEntry> sheets = sheetsFeed.getEntries();

		for (SpreadsheetEntry spreadsheetEntry : sheets) {
			if (spreadsheetEntry.getTitle().getPlainText().equals("PROFICIENT TCO tool_v0.7")) {
				processSheet(service, spreadsheetEntry);
			}
		}
	}

	private void processSheet(SpreadsheetService service, SpreadsheetEntry spreadsheet) throws IOException, ServiceException {
		for (String sheetName : updatedCells.keySet()) {
			WorksheetQuery worksheetQuery = new WorksheetQuery(spreadsheet.getWorksheetFeedUrl());
			worksheetQuery.setTitleExact(true);
			worksheetQuery.setTitleQuery(sheetName);

			WorksheetFeed worksheetFeed = service.query(worksheetQuery, WorksheetFeed.class);

			for (WorksheetEntry worksheet : worksheetFeed.getEntries()) {
				CellQuery cellQuery = new CellQuery(worksheet.getCellFeedUrl());

				CellFeed cellFeed = service.query(cellQuery, CellFeed.class);

				Map<CellKey, CellValue> map = updatedCells.get(sheetName);
				
				Map<String, CellEntry> cellEntryMap = getCellEntryMap(service, worksheet.getCellFeedUrl(), map.keySet());
				
				CellFeed batchRequest = new CellFeed();
				for (CellKey cellKey : map.keySet()) {
					CellValue value = map.get(cellKey);
					CellEntry batchEntry = new CellEntry(cellEntryMap.get(cellKey.getIdString()));
					batchEntry.changeInputValueLocal(value.toString());
					BatchUtils.setBatchId(batchEntry, cellKey.getIdString());
					BatchUtils.setBatchOperationType(batchEntry, BatchOperationType.UPDATE);
					batchRequest.getEntries().add(batchEntry);
				}
				Link batchLink = cellFeed.getLink(Link.Rel.FEED_BATCH, Link.Type.ATOM);
				CellFeed batchResponse = service.batch(new URL(batchLink.getHref()), batchRequest);

				// Check the results
				boolean isSuccess = true;
				for (CellEntry entry : batchResponse.getEntries()) {
					String batchId = BatchUtils.getBatchId(entry);
					if (!BatchUtils.isSuccess(entry)) {
						isSuccess = false;
						BatchStatus status = BatchUtils.getBatchStatus(entry);
						System.out.printf("%s failed (%s) %s", batchId, status.getReason(), status.getContent());
					}
				}

				System.out.println(isSuccess ? "\nBatch operations successful." : "\nBatch operations failed");
			}
		}
	}

	private Map<String, CellEntry> getCellEntryMap(SpreadsheetService ssSvc, URL cellFeedUrl, Set<CellKey> cellAddrs) throws IOException, ServiceException {
		CellFeed batchRequest = new CellFeed();
		for (CellKey cellId : cellAddrs) {
			CellEntry batchEntry = new CellEntry(cellId.getRow(), cellId.getCol(), cellId.getIdString());
			batchEntry.setId(String.format("%s/%s", cellFeedUrl.toString(), cellId.getIdString()));
			BatchUtils.setBatchId(batchEntry, cellId.getIdString());
			BatchUtils.setBatchOperationType(batchEntry, BatchOperationType.QUERY);
			batchRequest.getEntries().add(batchEntry);
		}

		CellFeed cellFeed = ssSvc.getFeed(cellFeedUrl, CellFeed.class);
		CellFeed queryBatchResponse = ssSvc.batch(new URL(cellFeed.getLink(Link.Rel.FEED_BATCH, Link.Type.ATOM).getHref()), batchRequest);

		Map<String, CellEntry> cellEntryMap = new HashMap<String, CellEntry>(cellAddrs.size());
		for (CellEntry entry : queryBatchResponse.getEntries()) {
			cellEntryMap.put(BatchUtils.getBatchId(entry), entry);
			System.out.printf("batch %s {CellEntry: id=%s editLink=%s inputValue=%s\n", BatchUtils.getBatchId(entry), entry.getId(), entry.getEditLink().getHref(), entry.getCell()
					.getInputValue());
		}

		return cellEntryMap;
	}

	private Credential getCredentials() throws IOException {
		HttpTransport transport = new NetHttpTransport();
		JacksonFactory jsonFactory = new JacksonFactory();

		String authorizationUrl = new GoogleAuthorizationCodeRequestUrl(clientId, redirectUrl, SCOPES).build();

		System.out.println("Go to the following link in your browser:");
		System.out.println(authorizationUrl);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("What is the authorization code?");
		String code = in.readLine();
		
		GoogleTokenResponse response = new GoogleAuthorizationCodeTokenRequest(transport, jsonFactory, clientId, clientSecret, code, redirectUrl).execute();

		return new GoogleCredential.Builder().setClientSecrets(clientId, clientSecret).setJsonFactory(jsonFactory).setTransport(transport).build()
				.setAccessToken(response.getAccessToken()).setRefreshToken(response.getRefreshToken());
	}

	private void setValueAtCell(String sheetName, int row, int col, int value) {
		if (!updatedCells.containsKey(sheetName)) {
			updatedCells.put(sheetName, new HashMap<CellKey, CellValue>());
		}
		updatedCells.get(sheetName).put(new CellKey(row, col), new CellValue(value));
	}

	private void setValueAtCell(String sheetName, int row, int col, double value) {
		if (!updatedCells.containsKey(sheetName)) {
			updatedCells.put(sheetName, new HashMap<CellKey, CellValue>());
		}
		updatedCells.get(sheetName).put(new CellKey(row, col), new CellValue(value));
	}

	public void setCollectiveNumberOfFloors(int nrFloors) {
		setValueAtCell("collective_input", 12, 5, nrFloors);
	}

	public void setCollectiveGrossFloorArea(double area) {
		setValueAtCell("collective_input", 13, 5, area);
	}

	public void setCollectiveExternalFloorArea(double area) {
		setValueAtCell("collective_input", 15, 5, area);
	}

	public void setCollectiveExternalRoofArea(double area) {
		setValueAtCell("collective_input", 16, 5, area);
	}

	public void setCollectiveExternalFacadeArea(double area) {
		setValueAtCell("collective_input", 17, 5, area);
	}

	public void setCollectiveVolume(double volume) {
		setValueAtCell("collective_input", 18, 5, volume);
	}

	public void setHouseHoldNumberOfFloors(int nrFloors) {
		setValueAtCell("household_input", 12, 5, nrFloors);
	}

	public void setHouseHoldGrossFloorArea(double area) {
		setValueAtCell("household_input", 13, 5, area);
	}

	public void setHouseHoldExternalFloorArea(double area) {
		setValueAtCell("household_input", 15, 5, area);
	}

	public void setHouseHoldExternalRoofArea(double area) {
		setValueAtCell("household_input", 16, 5, area);
	}

	public void setHouseHoldExternalFacadeAread(double area) {
		setValueAtCell("household_input", 17, 5, area);
	}

	public void setHouseHoldVolume(double volume) {
		setValueAtCell("household_input", 18, 5, volume);
	}
}