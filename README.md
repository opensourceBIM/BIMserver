BIMserver
=========

> Note 23-09-2016: To minimize cloning time of the main repository, we thrunk the git repository from 1.3GB to 600MB by removing some big files from the history. This means you'll have to clone the repository again if you have a copy on your machine, or git rebase.

The Building Information Modelserver (short: BIMserver) enables you to store and manage the information of a construction (or other building related) project. Data are stored in the open standard IFC. The BIMserver is nót a fileserver, but uses a model-driven architecture approach. This means that IFC data are stored in an underlying database. The main advantage of this approach is the possibility to query, merge and filter the BIM-model and generate IFC files on the fly.

Due to the multi-user support, multiple people can work on their own part of the model, while the complete model is updated on the fly. Other users can get update notifications when the model (or a part of it) is updated. Furthermore the BIMserver will warn you when other users have changed something in the model while you were editing.

BIMserver is build for developers. We've got a great wiki on https://github.com/opensourceBIM/BIMserver/wiki and are very active supporting developers on https://github.com/opensourceBIM/BIMserver/issues 

See a full list of features on http://www.bimserver.org/ 

Licence: GNU Affero General Public License, version 3 (see http://www.gnu.org/licenses/agpl-3.0.html)
Beware: this project makes intensive use of several other projects with different licenses. Some plugins and libraries are published under a different license.
