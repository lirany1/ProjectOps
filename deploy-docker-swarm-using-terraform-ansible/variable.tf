variable "aws_region" {
  description = "AWS region on which we will setup the swarm cluster"
  default = "us-east-1"
}

variable "ami" {
  description = "Ubuntu-16.04-amazon"
  default = "ami-43a15f3e"
}

variable "instance_type" {
  description = "Instance type"
  default = "t2.micro"
}

variable "key_path" {
  description = "SSH Public Key path"
  default = "/home/liran/Desktop/liranew.pem"
}

variable "key_name" {
  description = "Desired name of Keypair..."
  default = "liranew"
}

variable "bootstrap_path" {
  description = "Script to install Docker Engine"
  default = "install_docker_machine_compose.sh"
}
