Setup Jenkins nodes (1 master and 2 slaves) on AWS using Amazon Linux AMI.
Install Jenkins on master
Let's create 3 instances 1 for a master and 2 for slaves
Note that the three instances should be in the same availability zone to avoid any bandwidth charges.
ssh key setup
The slaves should have the master's public key in their authorized_keys. So, first we need to create rsa key on the master:

$ ssh-keygen -t rsa
Generating public/private rsa key pair.
Enter file in which to save the key (/home/ec2-user/.ssh/id_rsa): 
Enter passphrase (empty for no passphrase): 
Enter same passphrase again: 
Your identification has been saved in /home/ec2-user/.ssh/id_rsa.
Your public key has been saved in /home/ec2-user/.ssh/id_rsa.pub.
The key fingerprint is:
b3:ca:78:39:2c:d1:c1:67:13:71:05:6d:d6:b3:e6:17 ec2-user@ip-172-31-44-59
The key's randomart image is:
+--[ RSA 2048]----+
|        ..o+..   |
|        ..  + o  |
|     .   . o   o |
|      o +     oE |
|     . +S.   o  .|
|    . .  o    . .|
|     o ..      . |
|    .o=.         |
|    .oo.         |
+-----------------+

Then, on the two slaves, copy the master's public key to authorized_keys:

$ echo "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC8o7NpoyqRwPtlCfgZR+5+Zi0bzqgu3ZwjFZyS0MbECAHDlohfORkNIjGT05LhylnapFrqumxefIrNnH1NtlVDJjCClDsMluPGE2AHaIdfVBY4iVuwRoNzzlRcZneRPIn/liQJfOHAXiI2kv11zPuvINpgnzGxlboF0AAY/Y3cUw4afe/x7AZaS6hj0kVuhJUeBTU/xNmC9mpWBsWQkf4+5oKmXKQ1xUZKTV3F7JuTOc00GKmDeUDxmDZOpSUTB8Zz55UvL3X/uUKH1fVsBSzFIug4iYZQ8zP22SBXOzyXXo4ANxqu1ms9xXT/rvXcmEyZV6c33JAmp0cOPdWzfqqD ec2-user@ip-172-31-44-59" >> authorized_keys
Do the same to the "slave-2" node as well.

Install Jenkins on master node
Let's install Jenkins on the master node. We'll use LTS YUM repository for the LTS Release Line:

$ sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo
$ sudo rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key
$ sudo yum install jenkins

Start the Jenkins:

$ sudo service jenkins start
Starting Jenkins                                           [  OK  ]

Setting up slave nodes
On master Jenkins, click "Build Executor Status", and select "New Node". Type in "node-1" for "Node name", and select "Permanent Agent"
For Credential, we paste the master's private key (~/.ssh/id_rsa) 

In case when the slave may remain in offline, we need to install java on the slave node:

$ sudo yum install java

For the 2nd slave node, we can just copy the 1st node and use it after naming it as "node-2"
The only thing we need to change is the private ip-address of the slave instance!

Click the "Save" button
