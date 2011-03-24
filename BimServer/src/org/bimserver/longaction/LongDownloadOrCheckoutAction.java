package org.bimserver.longaction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.activation.DataHandler;

import org.bimserver.database.BimDatabase;
import org.bimserver.exceptions.NoSerializerFoundException;
import org.bimserver.ifc.EmfSerializer;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SerializerException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.User;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.ResultType;
import org.bimserver.shared.SCheckoutResult;
import org.bimserver.shared.UserException;
import org.bimserver.shared.LongActionState.ActionState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LongDownloadOrCheckoutAction extends LongAction {
	protected static final Logger LOGGER = LoggerFactory.getLogger(LongDownloadAction.class);
	protected final BimDatabase bimDatabase;
	protected final LongActionManager longActionManager;
	protected final AccessMethod accessMethod;
	protected final EmfSerializerFactory emfSerializerFactory;
	protected final DownloadParameters downloadParameters;
	protected final long currentUoid;
	protected ActionState state = ActionState.UNKNOWN;
	protected SCheckoutResult checkoutResult;
	protected User user;

	protected class DownloadParameters {
		private Set<Long> roids;
		private Set<Long> oids;
		private Set<String> guids;
		private String className;
		private ResultType resultType;

		public String getId() {
			return String.valueOf(this.hashCode());
		}

		public Set<Long> getRoids() {
			return roids;
		}

		public void setRoids(Set<Long> roids) {
			this.roids = roids;
		}

		public Long getRoid() {
			if (roids == null)
				return null;
			Iterator<Long> iterator = roids.iterator();
			return iterator.hasNext() ? iterator.next() : null;
		}

		public void setRoid(Long roid) {
			this.roids = new HashSet<Long>();
			roids.add(roid);
		}

		public Set<Long> getOids() {
			return oids;
		}

		public void setOids(Set<Long> oids) {
			this.oids = oids;
		}

		public Set<String> getGuids() {
			return guids;
		}

		public void setGuids(Set<String> guids) {
			this.guids = guids;
		}

		public ResultType getResultType() {
			return resultType;
		}

		public void setResultType(ResultType resultType) {
			this.resultType = resultType;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}
	}

	protected LongDownloadOrCheckoutAction(BimDatabase bimDatabase, LongActionManager longActionManager, AccessMethod accessMethod,
			EmfSerializerFactory emfSerializerFactory, long currentUoid) {
		super();
		this.bimDatabase = bimDatabase;
		this.longActionManager = longActionManager;
		this.accessMethod = accessMethod;
		this.emfSerializerFactory = emfSerializerFactory;
		this.downloadParameters = new DownloadParameters();
		this.currentUoid = currentUoid;
	}

	public SCheckoutResult getCheckoutResult() {
		return checkoutResult;
	}

	public String getIdentification() {
		return downloadParameters.getId();
	}

	public abstract LongActionState getState();

	public User getUser() {
		return user;
	}

	public boolean isRunning() {
		return longActionManager.isRunning(this);
	}

	protected SCheckoutResult convertModelToCheckoutResult(Project project, User user, IfcModel model, ResultType resultType)
			throws UserException, NoSerializerFoundException {
		SCheckoutResult checkoutResult = new SCheckoutResult();
		if (model.isValid()) {
			checkoutResult.setProjectName(project.getName());
			checkoutResult.setRevisionNr(model.getRevisionNr());
			EmfSerializer serializer;
			try {
				serializer = emfSerializerFactory.create(project, user, resultType, model, checkoutResult.getProjectName() + "."
						+ checkoutResult.getRevisionNr() + "." + resultType.getDefaultExtension());
				checkoutResult.setFile(new DataHandler(serializer));
			} catch (SerializerException e) {
				LOGGER.error("", e);
			}
		}
		return checkoutResult;
	}
}
