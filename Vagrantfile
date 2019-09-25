# -*- mode: ruby -*-
# vi: set ft=ruby :

VAGRANTFILE_API_VERSION = "2"

Vagrant.require_version ">= 1.5.0"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

  config.vm.box = "ubuntu/xenial64"
  config.vm.synced_folder ".", "/vagrant", type: 'nfs'

  config.vm.provider :virtualbox do |vb|
    vb.gui = false
    vb.customize [
      "modifyvm", :id,
      "--memory", "1024",
      # set available CPU's count
      "--cpus", 2
    ]
  end

  config.vm.network :forwarded_port, guest: 8080, host: 8081

  config.vm.define :dev, primary: true do |config|
    config.vm.network :private_network, ip: "192.168.5.2"
    config.vm.provision :ansible_local do |resume|
      resume.playbook = "playbook.yml"
      resume.verbose = false
    end
  end

end