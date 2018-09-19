# Instalação Bimserver
``` bash
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install openjdk-8-jdk
sudo apt-get install openjdk-8-jre-headless wget unzip
```

- verificar versao do java instalado
``` bash
java -version
```

``` bash
sudo groupadd tomcat
sudo mkdir /opt/tomcat
sudo useradd -s /bin/false -g tomcat -d /opt/tomcat tomcat
cd /tmp
curl -O http://apache.mirrors.ionfish.org/tomcat/tomcat-8/v8.5.33/bin/apache-tomcat-8.5.33.tar.gz
sudo tar xzvf apache-tomcat-8.5.33.tar.gz -C /opt/tomcat --strip-components=1
rm apache-tomcat-8.5.33.tar.gz
```

- caso o apache nao seja descompactado corretamente, corrigir o URL de download com a ultima versão do repositprio

``` bash
cd /opt/tomcat
sudo chgrp -R tomcat /opt/tomcat
sudo chmod -R g+r conf
sudo chmod g+x conf
sudo chown -R tomcat webapps/ work/ temp/ logs/
```

- execute o comando a seguir e copie o conteudo que irá  aparecer
- sudo update-java-alternatives -l

- substituir a variavel "Environment=JAVA_HOM" pelo valor que o comando anterior apresentou
- EX: /usr/lib/jvm/java-1.8.0-openjdk-amd64/jre

``` bash
sudo nano /etc/systemd/system/tomcat.service
```

- copie e cole o conteudo

``` bash
[Unit]
Description=Apache Tomcat Web Application Container
After=network.target

[Service]
Type=forking

Environment=JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64/jre
Environment=CATALINA_PID=/opt/tomcat/temp/tomcat.pid
Environment=CATALINA_HOME=/opt/tomcat
Environment=CATALINA_BASE=/opt/tomcat
Environment='CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC'
Environment='JAVA_OPTS=-Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom'

ExecStart=/opt/tomcat/bin/startup.sh
ExecStop=/opt/tomcat/bin/shutdown.sh

User=tomcat
Group=tomcat
UMask=0007
RestartSec=10
Restart=always

[Install]
WantedBy=multi-user.target
```

- reiniciar daemon
``` bash
sudo systemctl daemon-reload
```

- iniciar tomcat
``` bash
sudo systemctl start tomcat
```

- status tomcat
``` bash
sudo systemctl status tomcat
```

- iniciar o tomcat automaticamente
``` bash
sudo systemctl enable tomcat
```

- reiniciar tomcat
``` bash
sudo systemctl restart tomcat
```


- levantar Bimserver
``` bash
cd /opt/tomcat/webapps
sudo  rm -r -f *
sudo wget https://github.com/opensourceBIM/BIMserver/releases/download/v1.5.101/bimserverwar-1.5.101.war -O ROOT.war
sudo chown tomcat ROOT.war
sudo systemctl daemon-reload
sudo systemctl restart tomcat
```

BIMserver
=========

The Building Information Model server (short: BIMserver) enables you to store and manage the information of a construction (or other building related) project. Data is stored in the open standard IFC. The BIMserver is not a fileserver, but it uses a model-driven architecture approach. This means that IFC data is stored in an underlying database. The main advantage of this approach is the ability to query, merge and filter the BIM-model and generate IFC files on the fly.

Thanks to it's multi-user support, multiple people can work on their own part of the model, while the complete model is updated on the fly. Other users can get notifications when the model (or a part of it) is updated. Furthermore the BIMserver will warn you when other users have changed something in the model while you were editing.

BIMserver is built for developers. We've got a great wiki on https://github.com/opensourceBIM/BIMserver/wiki and are very active supporting developers on https://github.com/opensourceBIM/BIMserver/issues 

See a full list of features on http://www.bimserver.org/ 

Licence: GNU Affero General Public License, version 3 (see http://www.gnu.org/licenses/agpl-3.0.html)
Beware: this project makes intensive use of several other projects with different licenses. Some plugins and libraries are published under a different license.
