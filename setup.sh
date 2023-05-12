echo "------------------------------------------------------------------"
echo "-                    1.- DOCKER                                   "
echo "------------------------------------------------------------------"

echo "------------------------------------------------------------------"
echo "-                    1.1.- Install Yum Utils                      "
echo "------------------------------------------------------------------"

yum update

yum install -y yum-utils

echo "------------------------------------------------------------------"
echo "-                    1.2.- Add repositories Docker                "
echo "------------------------------------------------------------------"

sudo yum-config-manager --add-repo https://download.docker.com/linux/rhel/docker-ce.repo

sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo

echo "------------------------------------------------------------------"
echo "-                    1.3.- Install Docker                         "
echo "------------------------------------------------------------------"

sudo yum install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

echo "------------------------------------------------------------------"
echo "-                    1.4.- Check Docker Install                   "
echo "------------------------------------------------------------------"

sudo systemctl start docker

echo "------------------------------------------------------------------"
echo "-                   2.- Build Image Spring WS FirmarEC            "
echo "------------------------------------------------------------------"

cd Spring/

docker build -t spring/firmaec_ws .

cd ..

echo "------------------------------------------------------------------"
echo "-                   3.- Build Image Wildfly FirmaEC Mintel        "
echo "------------------------------------------------------------------"

cd Wildfly/

docker build -t jboss/wildfly-admin .

cd ..

echo "------------------------------------------------------------------"
echo "-                   4.- Check Images                              "
echo "------------------------------------------------------------------"

docker image ls

echo "------------------------------------------------------------------"
echo "-                   4.- Run Containers                            "
echo "------------------------------------------------------------------"

docker-compose up