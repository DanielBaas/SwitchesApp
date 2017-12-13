use CiscoSwitches;

insert into SwitchCisco (pk, user, host, port, pass, software, version, isAvailable) values
(1, 'admin', '192.168.69.3', 22, 'cisco', 'C3550 Software (C3550-IPSERVICESK9-M)', 'Version 12.2(44)SE6', 1);

insert into SwitchInterface (pk, interfaceType, ip, okStatus, method, status, protocol, switchCisco) values
(1, 'Vlan1', 'unassigned', 'YES', 'NVRAM', 'administratively down', 'down', 1),
(2, 'Vlan99', '192.168.69.3', 'YES', 'NVRAM', 'up', 'up', 1),
(3, 'Vlan100', '10.10.69.3', 'YES', 'NVRAM', 'up', 'up', 1),
(4, 'Vlan200', '172.16.69.3', 'YES', 'NVRAM', 'up', 'up', 1),
(5, 'FastEthernet0/1', 'unassigned', 'YES', 'unset', 'up', 'up', 1),
(6, 'FastEthernet0/2', 'unassigned', 'YES', 'unset', 'up', 'up', 1),
(7, 'FastEthernet0/3', 'unassigned', 'YES', 'unset', 'up', 'up', 1),
(8, 'FastEthernet0/4', 'unassigned', 'YES', 'unset', 'up', 'up', 1),
(9, 'FastEthernet0/5', 'unassigned', 'YES', 'unset', 'up', 'up', 1),
(10, 'FastEthernet0/6', 'unassigned', 'YES', 'unset', 'up', 'up', 1),
(11, 'FastEthernet0/7', 'unassigned', 'YES', 'unset', 'up', 'up', 1),
(12, 'FastEthernet0/8', 'unassigned', null, null, null, null, 1);