# ProjectOps
final project - 2018

**docker-swarm-using-terraform-ansible**

A node in a swarm cluster is any machine with docker engine installed and capable of hosting containers/services (When we run docker engine under swarm mode we often call applications as services). This is also referred as Docker node. A Docker node can be a physical machine or one or more virtual machines running on a physical host or cloud server. It is recommended to spread your docker nodes across multiple physical machines to provide availability and reliability for the applications running on the hosts. Docker Swarm environment consists of one or more manager nodes. To deploy an application on Docker Swarm we submit a request in the form of service definition to a manager node. Manager node performs orchestration and cluster management functions required to maintain the desired state of the farm. If there are multiple manager nodes in a swarm, the nodes elect a leader to conduct orchestration which implements leader election strategy.

Step-1
In this post we can see how to install Terraform and how to setup the AWS account for working ahead. After installing Terraform and setting up AWS account go to the next step.
NOTE: You need to create and download a key-pair using aws management console. Mine is : docker-key.pem
```
Step-2
Create a directory named swarm-deploy. create three files named variable.tf, security-groups.tf, main.tf and output.tf.
In variable.tf file I’m using region us-east-1 and Ubuntu-16.04 amazon machine image. You can set yours… :)
In output.tf file add the following
aws_instance.master.public_ip
aws_instance.worker1.public_ip
aws_instance.worker2.public_ip
```

Step-3
Create a shell script named install_docker_machine_compose.sh which will install docker. This script will execute in the provision time of EC2…

```
Step-4
Install Ansible

```
$ sudo apt-add-repository ppa:ansible/ansible
Press ENTER to accept the PPA addition.
$ sudo apt-get update
$ sudo apt-get install ansible
```
```
Step-5
There are a couple of ways of setting up a swarm cluster. The number of hosts running in a swarm cluster will be restricted to the host’s CPU and memory capacity.Setting up swarm environment is by using hosted environments like AWS.

We’ll create ansible script for creating swarm cluster(a manager node and two worker nodes). Create a file named playbook.yml in the same swarm-deploy directory
   
Create a directory named inventory and a file named hosts under inventory folder. Change the public ip and key-file-path which you’ll get after running the terraform apply command.

```
[masters]
<public ip instance1> ansible_user=ubuntu ansible_private_key_file=/path-to-your-keyfile/docker-key.pem
[workers]
<public ip instance2> ansible_user=ubuntu ansible_private_key_file=/path-to-your-keyfile/docker-key.pem
<public ip instance3> ansible_user=ubuntu ansible_private_key_file=/path-to-your-keyfile/docker-key.pem
```


Step-6
All the configuration files and scripts are now set. Run the following commands to deploy three instances using terraform and to create swarm cluser using ansible in those intances.

```
$ terraform init
$ terraform plan
$ terraform apply
```
```
$ ansible-playbook -i inventory/hosts playbook.yml
```

Our swarm cluster is ready. Let’s check the cluster using ssh in manager node.

```
$ ssh -i your_key_file.pem ubuntu@manager_public_ip

$ sudo docker node ls
```


