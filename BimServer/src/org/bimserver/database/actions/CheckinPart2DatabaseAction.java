package org.bimserver.database.actions;

import java.util.Date;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.merging.IncrementingOidProvider;
import org.bimserver.merging.RevisionMerger;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.UserException;

public class CheckinPart2DatabaseAction extends BimDatabaseAction<Void> {

	private final IfcModelInterface ifcModel;
	private final long actingUoid;
	private final long croid;
	private final boolean merge;
	private final BimServer bimServer;

	public CheckinPart2DatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, IfcModelInterface ifcModel, long actingUoid, long croid, boolean merge) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.ifcModel = ifcModel;
		this.actingUoid = actingUoid;
		this.croid = croid;
		this.merge = merge;
	}

	@Override
	public Void execute() throws UserException, BimDeadlockException, BimDatabaseException {
		ConcreteRevision concreteRevision = getConcreteRevision(croid);
		try {
			Project project = concreteRevision.getProject();
			Revision lastRevision = project.getLastRevision();
			IfcModelInterface ifcModel = null;
			if (merge) {
				IfcModelSet ifcModelSet = new IfcModelSet();
				for (ConcreteRevision subRevision : lastRevision.getConcreteRevisions()) {
					IfcModel subModel = new IfcModel();
					getDatabaseSession().getMap(subModel, subRevision.getProject().getId(), subRevision.getId(), true);
					subModel.setDate(subRevision.getDate());
					ifcModelSet.add(subModel);
				}
				getIfcModel().setDate(new Date());
				IfcModelInterface newModel = getIfcModel();
				newModel.fixOids(getDatabaseSession());
				IfcModelInterface oldModel = bimServer.getMergerFactory().createMerger().merge(project, ifcModelSet, bimServer.getSettingsManager().getSettings().isIntelligentMerging());
				
				oldModel.setObjectOids();
				newModel.setObjectOids();
				oldModel.indexGuids();
				newModel.indexGuids();
				newModel.fixOids(new IncrementingOidProvider(oldModel.getHighestOid() + 1));

				RevisionMerger revisionMerger = new RevisionMerger(oldModel, (IfcModel) newModel);
				ifcModel = revisionMerger.merge();
				revisionMerger.cleanupUnmodified();
				
				for (IdEObject idEObject : ifcModel.getValues()) {
					idEObject.setRid(concreteRevision.getId());
					idEObject.setPid(concreteRevision.getProject().getId());
				}
			} else {
				ifcModel = getIfcModel();
			}
			if (project.getConcreteRevisions().size() != 0 && !merge) {
				// There already was a revision, lets delete it (only when not merging)
				getDatabaseSession().clearProject(project.getId(), concreteRevision.getId() - 1, concreteRevision.getId());
			}
			getDatabaseSession().store(ifcModel.getValues(), project.getId(), concreteRevision.getId());
			for (Revision revision : concreteRevision.getRevisions()) {
				revision.setState(CheckinState.DONE);
				getDatabaseSession().store(revision);
			}
			concreteRevision.setState(CheckinState.DONE);
			getDatabaseSession().store(concreteRevision);
		} catch (Throwable e) {
			if (e instanceof BimDeadlockException) {
				// Let this one slide
				throw (BimDeadlockException)e;
			}
			for (Revision revision : concreteRevision.getRevisions()) {
				revision.setState(CheckinState.ERROR);
				revision.setLastError(e.getMessage());
			}
			throw new UserException(e);
		}
		return null;
	}

	public IfcModelInterface getIfcModel() {
		return ifcModel;
	}

	public long getActingUid() {
		return actingUoid;
	}

	public long getCroid() {
		return croid;
	}
}