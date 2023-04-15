firewall {
    all-ping enable
    broadcast-ping disable
    ipv6-name WANv6_IN {
        default-action drop
        description "WAN inbound traffic forwarded to LAN"
        enable-default-log
        rule 10 {
            action accept
            description "Allow established/related sessions"
            state {
                established enable
                related enable
            }
        }
        rule 20 {
            action drop
            description "Drop invalid state"
            state {
                invalid enable
            }
        }
    }
    ipv6-name WANv6_LOCAL {
        default-action drop
        description "WAN inbound traffic to the router"
        enable-default-log
        rule 10 {
            action accept
            description "Allow established/related sessions"
            state {
                established enable
                related enable
            }
        }
        rule 20 {
            action drop
            description "Drop invalid state"
            state {
                invalid enable
            }
        }
        rule 30 {
            action accept
            description "Allow IPv6 icmp"
            protocol ipv6-icmp
        }
        rule 40 {
            action accept
            description "allow dhcpv6"
            destination {
                port 546
            }
            protocol udp
            source {
                port 547
            }
        }
    }
    ipv6-receive-redirects disable
    ipv6-src-route disable
    ip-src-route disable
    log-martians enable
    name WAN_IN {
        default-action accept
        description "WAN to internal"
        rule 10 {
            action accept
            description "Allow established/related"
            state {
                established enable
                related enable
            }
        }
        rule 20 {
            action drop
            description "Drop invalid state"
            state {
                invalid enable
            }
        }
    }
    name WAN_LOCAL {
        default-action accept
        description "WAN to router"
        rule 10 {
            action accept
            description "Allow established/related"
            state {
                established enable
                related enable
            }
        }
        rule 20 {
            action drop
            description "Drop invalid state"
            state {
                invalid enable
            }
        }
        rule 21 {
            action accept
            description "ER Access From Web"
            log disable
            protocol tcp_udp
            source {
                address 0.0.0.0/0
                port 80,443
            }
        }
        rule 30 {
            action accept
            description WireGuard
            destination {
                port 51820
            }
            protocol udp
        }
    }
    receive-redirects disable
    send-redirects enable
    source-validation disable
    syn-cookies enable
}
interfaces {
    ethernet eth0 {
        description Local
        duplex auto
        speed auto
    }
    ethernet eth1 {
        description Local
        duplex auto
        speed auto
    }
    ethernet eth2 {
        description Local
        duplex auto
        speed auto
    }
    ethernet eth3 {
        description Local
        duplex auto
        speed auto
    }
    ethernet eth4 {
        description Local
        duplex auto
        speed auto
    }
    ethernet eth5 {
        description Local
        duplex auto
        speed auto
    }
    ethernet eth6 {
        description Local
        duplex auto
        speed auto
    }
    ethernet eth7 {
        description Local
        duplex auto
        speed auto
    }
    ethernet eth8 {
        description Local2
        duplex auto
        speed auto
    }
    ethernet eth9 {
        address dhcp
        description Internet
        duplex auto
        firewall {
            in {
                ipv6-name WANv6_IN
                name WAN_IN
            }
            local {
                ipv6-name WANv6_LOCAL
                name WAN_LOCAL
            }
        }
        poe {
            output off
        }
        speed auto
    }
    ethernet eth10 {
        address 10.9.3.1/24
        duplex auto
        speed auto
    }
    ethernet eth11 {
        address 10.9.10.1/24
        description "Management Lan"
        duplex auto
        speed auto
        vif 20 {
            address 10.9.20.1/24
            description "VLAN 20"
            mtu 1500
        }
        vif 21 {
            address 10.9.21.1/24
            description "VLAN 21"
            mtu 1500
        }
        vif 22 {
            address 10.9.22.1/24
            description "VLAN 22"
            mtu 1500
        }
        vif 23 {
            address 10.9.23.1/24
            description "VLAN 23"
            mtu 1500
        }
        vif 24 {
            address 10.9.24.1/24
            description "VLAN 24"
            mtu 1500
        }
        vif 25 {
            address 10.9.25.1/24
            description "VLAN 25"
            mtu 1500
        }
        vif 26 {
            address 10.9.26.1/24
            description "VLAN 26"
            mtu 1500
        }
        vif 27 {
            address 10.9.27.1/24
            description "VLAN 27"
            mtu 1500
        }
        vif 28 {
            address 10.9.28.1/24
            description "VLAN 28"
            mtu 1500
        }
        vif 29 {
            address 10.9.29.1/24
            description "VLAN 29"
            mtu 1500
        }
        vif 30 {
            address 10.9.30.1/24
            description "VLAN 30"
            mtu 1500
        }
        vif 31 {
            address 10.9.31.1/24
            description "VLAN 31"
            mtu 1500
        }
        vif 32 {
            address 10.9.32.1/24
            description "VLAN 32"
            mtu 1500
        }
        vif 33 {
            address 10.9.33.1/24
            description "VLAN 33"
            mtu 1500
        }
        vif 34 {
            address 10.9.34.1/24
            description "VLAN 34"
            mtu 1500
        }
        vif 35 {
            address 10.9.35.1/24
            description "VLAN 35"
            mtu 1500
        }
        vif 36 {
            address 10.9.36.1/24
            description "VLAN 36"
            mtu 1500
        }
        vif 37 {
            address 10.9.37.1/24
            description "VLAN 37"
            mtu 1500
        }
        vif 38 {
            address 10.9.38.1/24
            description "VLAN 38"
            mtu 1500
        }
        vif 39 {
            address 10.9.39.1/24
            description "VLAN 39"
            mtu 1500
        }
        vif 40 {
            address 10.9.40.1/24
            description "VLAN 40"
            mtu 1500
        }
        vif 41 {
            address 10.9.41.1/24
            description "VLAN 41"
            mtu 1500
        }
        vif 42 {
            address 10.9.42.1/24
            description "VLAN 42"
            mtu 1500
        }
        vif 43 {
            address 10.9.43.1/24
            description "VLAN 43"
            mtu 1500
        }
        vif 44 {
            address 10.9.44.1/24
            description "VLAN 44"
            mtu 1500
        }
        vif 45 {
            address 10.9.45.1/24
            description "VLAN 45"
            mtu 1500
        }
        vif 46 {
            address 10.9.46.1/24
            description "VLAN 46"
            mtu 1500
        }
        vif 47 {
            address 10.9.47.1/24
            description "VLAN 47"
            mtu 1500
        }
        vif 48 {
            address 10.9.48.1/24
            description "VLAN 48"
            mtu 1500
        }
        vif 49 {
            address 10.9.49.1/24
            description "VLAN 49"
            mtu 1500
        }
        vif 50 {
            address 10.9.50.1/24
            description "Rise Free Wifi"
            mtu 1500
        }
        vif 51 {
            address 10.9.51.1/24
            description "Rise Employee Wifi"
            mtu 1500
        }
        vif 60 {
            address 10.9.60.1/24
            description "VLAN 60"
        }
        vif 61 {
            address 10.9.61.1/24
            description "VLAN 61"
        }
        vif 62 {
            address 10.9.62.1/24
            description "VLAN 62"
        }
        vif 63 {
            address 10.9.63.1/24
            description "VLAN 63"
        }
        vif 64 {
            address 10.9.64.1/24
            description "VLAN 64"
        }
        vif 65 {
            address 10.9.65.1/24
            description "VLAN 65"
        }
        vif 66 {
            address 10.9.66.1/24
            description "VLAN 66"
        }
        vif 67 {
            address 10.9.67.1/24
            description "VLAN 67"
        }
        vif 68 {
            address 10.9.68.1/24
            description "VLAN 68"
        }
        vif 69 {
            address 10.9.69.1/24
            description "VLAN 69"
        }
        vif 70 {
            address 10.9.70.1/24
            description "VLAN 70"
        }
        vif 71 {
            address 10.9.71.1/24
            description "VLAN 71"
        }
        vif 72 {
            address 10.9.72.1/24
            description "VLAN 72"
        }
    }
    loopback lo {
    }
    switch switch0 {
        address 192.168.1.1/24
        description Local
        mtu 1500
        switch-port {
            interface eth0 {
            }
            interface eth1 {
            }
            interface eth2 {
            }
            interface eth4 {
            }
            interface eth5 {
            }
            interface eth6 {
            }
            interface eth7 {
            }
            vlan-aware disable
        }
    }
    wireguard wg0 {
        address 10.40.8.35/24
        listen-port 51820
        mtu 1420
        peer Iwn/MEa7BvE1wahC5r8TYSZQrWbEVPe/TxvlAu/K01U= {
            allowed-ips 10.40.8.1/24
            description LS-Mall-ER-12
            endpoint 216.200.13.44:51820
            persistent-keepalive 15
        }
        private-key /home/ubnt/server_keys/privatekey
        route-allowed-ips true
    }
}
service {
    dhcp-server {
        disabled false
        hostfile-update disable
        shared-network-name Management-Lan {
            authoritative disable
            subnet 10.9.10.0/24 {
                default-router 10.9.10.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.10.10 {
                    stop 10.9.10.254
                }
                unifi-controller 50.212.141.99
            }
        }
        shared-network-name Rise-Employee-Wifi-Lan {
            authoritative disable
            subnet 10.9.51.0/24 {
                default-router 10.9.51.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.51.10 {
                    stop 10.9.51.254
                }
            }
        }
        shared-network-name Rise-Free-Wifi-Lan {
            authoritative disable
            subnet 10.9.50.0/24 {
                default-router 10.9.50.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.50.10 {
                    stop 10.9.50.254
                }
            }
        }
        shared-network-name VLAN-20 {
            authoritative disable
            subnet 10.9.20.0/24 {
                default-router 10.9.20.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.20.10 {
                    stop 10.9.20.25
                }
            }
        }
        shared-network-name VLAN-21 {
            authoritative disable
            subnet 10.9.21.0/24 {
                default-router 10.9.21.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.21.10 {
                    stop 10.9.21.25
                }
            }
        }
        shared-network-name VLAN-22 {
            authoritative disable
            subnet 10.9.22.0/24 {
                default-router 10.9.22.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.22.10 {
                    stop 10.9.22.25
                }
            }
        }
        shared-network-name VLAN-23 {
            authoritative disable
            subnet 10.9.23.0/24 {
                default-router 10.9.23.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.23.10 {
                    stop 10.9.23.25
                }
            }
        }
        shared-network-name VLAN-24 {
            authoritative disable
            subnet 10.9.24.0/24 {
                default-router 10.9.24.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.24.10 {
                    stop 10.9.24.25
                }
            }
        }
        shared-network-name VLAN-25 {
            authoritative disable
            subnet 10.9.25.0/24 {
                default-router 10.9.25.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.25.10 {
                    stop 10.9.25.25
                }
            }
        }
        shared-network-name VLAN-26 {
            authoritative disable
            subnet 10.9.26.0/24 {
                default-router 10.9.26.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.26.10 {
                    stop 10.9.26.25
                }
            }
        }
        shared-network-name VLAN-27 {
            authoritative disable
            subnet 10.9.27.0/24 {
                default-router 10.9.27.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.27.10 {
                    stop 10.9.27.25
                }
            }
        }
        shared-network-name VLAN-28 {
            authoritative disable
            subnet 10.9.28.0/24 {
                default-router 10.9.28.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.28.10 {
                    stop 10.9.28.25
                }
            }
        }
        shared-network-name VLAN-29 {
            authoritative disable
            subnet 10.9.29.0/24 {
                default-router 10.9.29.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.29.10 {
                    stop 10.9.29.25
                }
            }
        }
        shared-network-name VLAN-30 {
            authoritative disable
            subnet 10.9.30.0/24 {
                default-router 10.9.30.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.30.10 {
                    stop 10.9.30.25
                }
            }
        }
        shared-network-name VLAN-31 {
            authoritative disable
            subnet 10.9.31.0/24 {
                default-router 10.9.31.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.31.10 {
                    stop 10.9.31.25
                }
            }
        }
        shared-network-name VLAN-32 {
            authoritative disable
            subnet 10.9.32.0/24 {
                default-router 10.9.32.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.32.10 {
                    stop 10.9.32.25
                }
            }
        }
        shared-network-name VLAN-33 {
            authoritative disable
            subnet 10.9.33.0/24 {
                default-router 10.9.33.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.33.10 {
                    stop 10.9.33.25
                }
            }
        }
        shared-network-name VLAN-34 {
            authoritative disable
            subnet 10.9.34.0/24 {
                default-router 10.9.34.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.34.10 {
                    stop 10.9.34.25
                }
            }
        }
        shared-network-name VLAN-35 {
            authoritative disable
            subnet 10.9.35.0/24 {
                default-router 10.9.35.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.35.10 {
                    stop 10.9.35.25
                }
            }
        }
        shared-network-name VLAN-36 {
            authoritative disable
            subnet 10.9.36.0/24 {
                default-router 10.9.36.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.36.10 {
                    stop 10.9.36.25
                }
            }
        }
        shared-network-name VLAN-37 {
            authoritative disable
            subnet 10.9.37.0/24 {
                default-router 10.9.37.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.37.10 {
                    stop 10.9.37.25
                }
            }
        }
        shared-network-name VLAN-38 {
            authoritative disable
            subnet 10.9.38.0/24 {
                default-router 10.9.38.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.38.10 {
                    stop 10.9.38.25
                }
            }
        }
        shared-network-name VLAN-39 {
            authoritative disable
            subnet 10.9.39.0/24 {
                default-router 10.9.39.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.39.10 {
                    stop 10.9.39.25
                }
            }
        }
        shared-network-name VLAN-40 {
            authoritative disable
            subnet 10.9.40.0/24 {
                default-router 10.9.40.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.40.10 {
                    stop 10.9.40.25
                }
            }
        }
        shared-network-name VLAN-41 {
            authoritative disable
            subnet 10.9.41.0/24 {
                default-router 10.9.41.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.41.10 {
                    stop 10.9.41.25
                }
            }
        }
        shared-network-name VLAN-42 {
            authoritative disable
            subnet 10.9.42.0/24 {
                default-router 10.9.42.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.42.10 {
                    stop 10.9.42.25
                }
            }
        }
        shared-network-name VLAN-43 {
            authoritative disable
            subnet 10.9.43.0/24 {
                default-router 10.9.43.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.43.10 {
                    stop 10.9.43.25
                }
            }
        }
        shared-network-name VLAN-44 {
            authoritative disable
            subnet 10.9.44.0/24 {
                default-router 10.9.44.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.44.10 {
                    stop 10.9.44.25
                }
            }
        }
        shared-network-name VLAN-45 {
            authoritative disable
            subnet 10.9.45.0/24 {
                default-router 10.9.45.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.45.10 {
                    stop 10.9.45.25
                }
            }
        }
        shared-network-name VLAN-46 {
            authoritative disable
            subnet 10.9.46.0/24 {
                default-router 10.9.46.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.46.10 {
                    stop 10.9.46.25
                }
            }
        }
        shared-network-name VLAN-47 {
            authoritative disable
            subnet 10.9.47.0/24 {
                default-router 10.9.47.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.47.10 {
                    stop 10.9.47.25
                }
            }
        }
        shared-network-name VLAN-48 {
            authoritative disable
            subnet 10.9.48.0/24 {
                default-router 10.9.48.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.48.10 {
                    stop 10.9.48.25
                }
            }
        }
        shared-network-name VLAN-49 {
            authoritative disable
            subnet 10.9.49.0/24 {
                default-router 10.9.49.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.49.10 {
                    stop 10.9.49.25
                }
            }
        }
        shared-network-name VLAN-60 {
            authoritative enable
            subnet 10.9.60.0/24 {
                default-router 10.9.60.1
                dns-server 8.8.8.8
                dns-server 8.8.4.4
                lease 86400
                start 10.9.60.10 {
                    stop 10.9.60.25
                }
            }
        }
        shared-network-name VLAN-61 {
            authoritative enable
            subnet 10.9.61.0/24 {
                default-router 10.9.61.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.61.10 {
                    stop 10.9.61.25
                }
            }
        }
        shared-network-name VLAN-62 {
            authoritative enable
            subnet 10.9.62.0/24 {
                default-router 10.9.62.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.62.10 {
                    stop 10.9.62.25
                }
            }
        }
        shared-network-name VLAN-63 {
            authoritative enable
            subnet 10.9.63.0/24 {
                default-router 10.9.63.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.63.10 {
                    stop 10.9.63.25
                }
            }
        }
        shared-network-name VLAN-64 {
            authoritative enable
            subnet 10.9.64.0/24 {
                default-router 10.9.64.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.64.10 {
                    stop 10.9.64.25
                }
            }
        }
        shared-network-name VLAN-65 {
            authoritative enable
            subnet 10.9.65.0/24 {
                default-router 10.9.65.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.65.10 {
                    stop 10.9.65.25
                }
            }
        }
        shared-network-name VLAN-66 {
            authoritative enable
            subnet 10.9.66.0/24 {
                default-router 10.9.66.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.66.10 {
                    stop 10.9.66.25
                }
            }
        }
        shared-network-name VLAN-67 {
            authoritative enable
            subnet 10.9.67.0/24 {
                default-router 10.9.67.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.67.10 {
                    stop 10.9.67.25
                }
            }
        }
        shared-network-name VLAN-68 {
            authoritative enable
            subnet 10.9.68.0/24 {
                default-router 10.9.68.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.68.10 {
                    stop 10.9.68.25
                }
            }
        }
        shared-network-name VLAN-69 {
            authoritative enable
            subnet 10.9.69.0/24 {
                default-router 10.9.69.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.69.10 {
                    stop 10.9.69.25
                }
            }
        }
        shared-network-name VLAN-70 {
            authoritative enable
            subnet 10.9.70.0/24 {
                default-router 10.9.70.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.70.10 {
                    stop 10.9.70.25
                }
            }
        }
        shared-network-name VLAN-71 {
            authoritative enable
            subnet 10.9.71.0/24 {
                default-router 10.9.71.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.71.10 {
                    stop 10.9.71.25
                }
            }
        }
        shared-network-name VLAN-72 {
            authoritative enable
            subnet 10.9.72.0/24 {
                default-router 10.9.72.1
                dns-server 8.8.8.8
                lease 86400
                start 10.9.72.10 {
                    stop 10.9.72.25
                }
            }
        }
        static-arp disable
        use-dnsmasq disable
    }
    dns {
        forwarding {
            cache-size 10000
            listen-on eth8
            listen-on switch0
        }
    }
    gui {
        http-port 80
        https-port 443
        older-ciphers enable
    }
    nat {
        rule 5010 {
            description "masquerade for WAN"
            outbound-interface eth9
            type masquerade
        }
    }
    ssh {
        port 22
        protocol-version v2
    }
    suspend {
        allow-domain portal.wispmen.com
        allow-ip 127.0.1.1
        redirect {
            url http://portal.wispmen.com:81/crm/suspension/
        }
        user-ip 10.0.21.23
        user-ip 10.5.35.10
        user-ip 10.2.30.10
        user-ip 10.1.22.19
        user-ip 10.4.23.12
        user-ip 10.32.21.12
        user-ip 10.0.44.21
        user-ip 10.1.22.21
        user-ip 10.1.28.12
        user-ip 10.0.21.12
        user-ip 10.5.77.25
        user-ip 10.2.27.10
        user-ip 10.0.31.23
        user-ip 10.7.21.17
        user-ip 10.33.48.22
        user-ip 10.1.21.23
        user-ip 10.1.60.22
        user-ip 10.5.44.11
        user-ip 10.32.21.25
        user-ip 10.5.77.22
        user-ip 10.5.77.10
        user-ip 10.2.27.20
        user-ip 10.5.35.21
        user-ip 10.1.27.25
        user-ip 10.4.28.15
        user-ip 10.0.21.16
        user-ip 10.4.23.20
        user-ip 10.1.25.24
        user-ip 10.1.23.15
        user-ip 10.4.28.23
        user-ip 10.32.22.11
        user-ip 10.1.22.24
        user-ip 10.0.26.21
        user-ip 10.1.22.23
        user-ip 10.0.31.18
        user-ip 10.1.25.11
        user-ip 10.33.48.16
        user-ip 10.0.26.20
        user-ip 10.3.20.18
        user-ip 10.0.22.15
        user-ip 10.1.23.20
        user-ip 10.0.44.15
        user-ip 10.32.26.25
        user-ip 10.3.20.15
        user-ip 10.1.60.15
        user-ip 10.32.26.21
        user-ip 10.32.23.12
        user-ip 10.1.21.22
        user-ip 10.1.21.17
        user-ip 10.4.25.17
        user-ip 10.0.35.16
        user-ip 10.1.60.13
        user-ip 10.32.23.22
        user-ip 10.32.23.19
        user-ip 10.1.22.20
        user-ip 10.2.30.12
        user-ip 10.0.21.21
        user-ip 10.32.23.18
        user-ip 10.3.20.14
        user-ip 10.32.22.22
        user-ip 10.1.23.18
        user-ip 10.5.77.11
        user-ip 10.32.23.24
        user-ip 10.0.44.18
        user-ip 10.1.22.25
        user-ip 10.32.23.16
        user-ip 10.2.27.22
        user-ip 10.1.27.18
        user-ip 10.4.28.16
        user-ip 10.0.29.21
        user-ip 10.33.48.14
        user-ip 10.32.21.15
        user-ip 10.33.34.14
        user-ip 10.3.20.24
        user-ip 10.3.20.12
        user-ip 10.0.29.20
        user-ip 10.1.21.12
        user-ip 10.1.38.4
        user-ip 10.2.27.25
        user-ip 10.1.27.22
        user-ip 10.0.38.18
        user-ip 10.0.21.20
        user-ip 10.32.22.10
        user-ip 10.5.38.15
        user-ip 10.7.21.13
        user-ip 10.3.20.21
        user-ip 10.1.22.11
        user-ip 10.0.38.11
        user-ip 10.0.29.23
        user-ip 10.1.60.10
        user-ip 10.0.29.12
        user-ip 10.0.31.25
        user-ip 10.0.44.17
        user-ip 10.1.27.21
        user-ip 10.0.31.15
        user-ip 10.4.25.22
        user-ip 10.33.34.15
        user-ip 10.32.21.14
        user-ip 10.0.22.20
        user-ip 10.32.22.23
        user-ip 10.1.23.16
        user-ip 10.5.77.16
        user-ip 10.1.21.18
        user-ip 10.32.26.18
        user-ip 10.32.22.24
        user-ip 10.0.22.22
        user-ip 10.0.22.16
        user-ip 10.4.28.21
        user-ip 10.5.44.14
        user-ip 10.1.28.25
        user-ip 10.4.28.17
        user-ip 10.1.21.14
        user-ip 10.4.25.16
        user-ip 10.0.31.19
        user-ip 10.1.70.103
        user-ip 10.5.35.16
        user-ip 10.0.44.20
        user-ip 10.0.26.16
        user-ip 10.5.77.18
        user-ip 10.2.30.22
        user-ip 10.2.27.23
        user-ip 10.0.26.15
        user-ip 10.4.23.19
        user-ip 10.0.26.18
        user-ip 10.0.35.13
        user-ip 10.1.23.17
        user-ip 10.1.23.13
        user-ip 10.1.21.16
        user-ip 10.32.21.22
        user-ip 10.1.60.17
        user-ip 10.7.21.18
        user-ip 10.1.60.23
        user-ip 10.0.22.24
        user-ip 10.33.48.10
        user-ip 10.2.30.21
        user-ip 10.33.34.20
        user-ip 10.5.38.25
        user-ip 10.1.22.10
        user-ip 10.32.23.11
        user-ip 10.0.44.24
        user-ip 10.1.25.21
        user-ip 10.33.34.23
        user-ip 10.33.34.21
        user-ip 10.0.26.24
        user-ip 10.1.25.19
        user-ip 10.5.38.17
        user-ip 10.32.22.20
        user-ip 10.4.28.13
        user-ip 10.32.26.14
        user-ip 10.2.20.15
        user-ip 10.33.48.23
        user-ip 10.32.23.25
        user-ip 10.0.38.16
        user-ip 10.2.20.13
        user-ip 10.5.44.21
        user-ip 10.0.44.13
        user-ip 10.0.38.15
        user-ip 10.1.27.17
        user-ip 10.1.23.12
        user-ip 10.7.21.22
        user-ip 10.1.60.20
        user-ip 10.32.22.25
        user-ip 10.4.28.18
        user-ip 10.2.30.19
        user-ip 10.0.38.21
        user-ip 10.0.21.15
        user-ip 10.4.28.19
        user-ip 10.0.29.10
        user-ip 10.0.35.11
        user-ip 10.2.27.13
        user-ip 10.1.27.9
        user-ip 10.1.23.25
        user-ip 10.0.31.16
        user-ip 10.1.28.5
        user-ip 10.5.44.18
        user-ip 10.5.38.16
        user-ip 10.0.22.10
        user-ip 10.1.27.19
        user-ip 10.0.22.25
        user-ip 10.0.21.13
        user-ip 10.1.28.19
        user-ip 10.2.30.25
        user-ip 10.1.21.24
        user-ip 10.0.38.13
        user-ip 10.32.23.15
        user-ip 10.1.60.25
        user-ip 10.0.26.11
        user-ip 10.4.25.21
        user-ip 10.1.25.20
        user-ip 10.5.77.19
        user-ip 10.32.22.16
        user-ip 10.4.25.18
        user-ip 10.0.29.22
        user-ip 10.1.25.18
        user-ip 10.7.21.12
        user-ip 10.32.22.18
        user-ip 10.2.30.16
        user-ip 10.2.27.11
        user-ip 10.1.21.13
        user-ip 10.2.20.19
        user-ip 10.3.20.20
        user-ip 10.0.26.19
        user-ip 10.5.38.21
        user-ip 10.7.21.14
        user-ip 10.0.44.16
        user-ip 10.4.28.25
        user-ip 10.5.77.17
        user-ip 10.2.20.17
        user-ip 10.3.20.11
        user-ip 10.5.44.20
        user-ip 10.3.20.19
        user-ip 10.32.21.16
        user-ip 10.2.30.20
        user-ip 10.7.21.10
        user-ip 10.0.35.12
        user-ip 10.0.44.12
        user-ip 10.5.35.25
        user-ip 10.0.38.10
        user-ip 10.0.31.21
        user-ip 10.5.77.15
        user-ip 10.4.25.20
        user-ip 10.32.22.14
        user-ip 10.0.38.25
        user-ip 10.1.27.6
        user-ip 10.2.30.14
        user-ip 10.5.38.12
        user-ip 10.0.22.11
        user-ip 10.0.31.12
        user-ip 10.0.38.24
        user-ip 10.2.20.12
        user-ip 10.2.30.18
        user-ip 10.2.27.14
        user-ip 10.32.26.24
        user-ip 10.0.26.12
        user-ip 10.4.23.25
        user-ip 10.5.35.15
        user-ip 10.0.29.14
        user-ip 10.1.22.18
        user-ip 10.0.21.24
        user-ip 10.2.27.21
        user-ip 10.2.27.16
        user-ip 10.1.28.4
        user-ip 10.7.21.19
        user-ip 10.32.21.24
        user-ip 10.5.77.20
        user-ip 10.0.31.22
        user-ip 10.2.27.17
        user-ip 10.33.48.15
        user-ip 10.33.34.12
        user-ip 10.1.23.10
        user-ip 10.1.60.11
        user-ip 10.5.77.24
        user-ip 10.0.26.14
        user-ip 10.4.25.14
        user-ip 10.5.38.10
        user-ip 10.0.26.17
        user-ip 10.4.23.18
        user-ip 10.1.23.24
        user-ip 10.32.23.14
        user-ip 10.33.34.11
        user-ip 10.0.26.23
        user-ip 10.5.35.22
        user-ip 10.2.30.11
        user-ip 10.0.31.14
        user-ip 10.7.21.15
        user-ip 10.4.23.23
        user-ip 10.0.29.25
        user-ip 10.32.26.15
        user-ip 10.5.44.10
        user-ip 10.2.20.25
        user-ip 10.1.22.22
        user-ip 10.3.20.17
        user-ip 10.5.38.19
        user-ip 10.1.22.14
        user-ip 10.32.23.23
        user-ip 10.3.20.25
        user-ip 10.32.26.10
        user-ip 10.4.28.20
        user-ip 10.1.25.14
        user-ip 10.7.21.24
        user-ip 10.2.30.24
        user-ip 10.4.23.17
        user-ip 10.5.44.15
        user-ip 10.0.31.24
        user-ip 10.0.21.22
        user-ip 10.1.21.11
        user-ip 10.0.44.23
        user-ip 10.32.23.21
        user-ip 10.0.35.20
        user-ip 10.5.44.13
        user-ip 10.4.25.24
        user-ip 10.1.28.10
        user-ip 10.32.22.21
        user-ip 10.1.23.21
        user-ip 10.32.26.22
        user-ip 10.1.23.19
        user-ip 10.1.27.4
        user-ip 10.4.25.12
        user-ip 10.33.34.17
        user-ip 10.32.21.10
        user-ip 10.1.60.21
        user-ip 10.1.28.14
        user-ip 10.0.26.13
        user-ip 10.32.26.11
        user-ip 10.4.28.24
        user-ip 10.0.29.16
        user-ip 10.1.28.24
        user-ip 10.0.38.12
        user-ip 10.32.21.13
        user-ip 10.0.29.17
        user-ip 10.0.21.17
        user-ip 10.32.26.23
        user-ip 10.1.25.22
        user-ip 10.1.22.15
        user-ip 10.1.27.11
        user-ip 10.33.34.22
        user-ip 10.5.35.13
        user-ip 10.5.35.19
        user-ip 10.4.25.11
        user-ip 10.32.26.17
        user-ip 10.0.35.18
        user-ip 10.5.38.22
        user-ip 10.0.29.13
        user-ip 10.2.20.24
        user-ip 10.1.60.24
        user-ip 10.2.20.10
        user-ip 10.0.35.21
        user-ip 10.3.20.22
        user-ip 10.7.21.11
        user-ip 10.5.38.24
        user-ip 10.0.22.19
        user-ip 10.1.70.14
        user-ip 10.5.38.18
        user-ip 10.7.21.20
        user-ip 10.0.35.14
        user-ip 10.32.21.23
        user-ip 10.4.25.13
        user-ip 10.0.21.10
        user-ip 10.1.28.16
        user-ip 10.7.21.25
        user-ip 10.0.44.22
        user-ip 10.33.34.24
        user-ip 10.32.23.13
        user-ip 10.5.35.11
        user-ip 10.2.21.12
        user-ip 10.0.35.25
        user-ip 10.1.22.17
        user-ip 10.4.23.14
        user-ip 10.1.25.10
        user-ip 10.0.22.13
        user-ip 10.7.21.16
        user-ip 10.33.48.20
        user-ip 10.32.21.11
        user-ip 10.1.28.15
        user-ip 10.2.20.16
        user-ip 10.1.23.11
        user-ip 10.33.48.11
        user-ip 10.4.28.10
        user-ip 10.2.30.13
        user-ip 10.32.21.17
        user-ip 10.1.60.19
        user-ip 10.1.27.24
        user-ip 10.32.26.13
        user-ip 10.1.60.8
        user-ip 10.0.31.11
        user-ip 10.5.44.22
        user-ip 10.0.35.19
        user-ip 10.32.21.18
        user-ip 10.2.30.15
        user-ip 10.5.77.14
        user-ip 10.1.25.12
        user-ip 10.32.23.17
        user-ip 10.1.23.22
        user-ip 10.32.22.13
        user-ip 10.0.35.23
        user-ip 10.5.38.13
        user-ip 10.7.21.21
        user-ip 10.1.23.14
        user-ip 10.7.21.23
        user-ip 10.5.38.20
        user-ip 10.0.22.17
        user-ip 10.5.44.25
        user-ip 10.32.22.15
        user-ip 10.1.25.25
        user-ip 10.2.20.20
        user-ip 10.1.21.10
        user-ip 10.32.26.12
        user-ip 10.33.34.18
        user-ip 10.1.27.23
        user-ip 10.0.29.19
        user-ip 10.0.26.10
        user-ip 10.0.21.25
        user-ip 10.5.35.24
        user-ip 10.1.25.17
        user-ip 10.2.20.11
        user-ip 10.5.77.13
        user-ip 10.1.60.14
        user-ip 10.1.22.16
        user-ip 10.32.22.19
        user-ip 10.0.31.10
        user-ip 10.32.21.19
        user-ip 10.33.48.19
        user-ip 10.4.23.22
        user-ip 10.5.44.24
        user-ip 10.2.27.18
        user-ip 10.5.35.17
        user-ip 10.5.35.12
        user-ip 10.4.25.23
        user-ip 10.4.25.19
        user-ip 10.0.35.10
        user-ip 10.33.48.25
        user-ip 10.33.48.12
        user-ip 10.3.20.16
        user-ip 10.0.38.20
        user-ip 10.32.26.20
        user-ip 10.4.23.15
        user-ip 10.33.34.25
        user-ip 10.0.38.19
        user-ip 10.33.48.24
        user-ip 10.3.20.10
        user-ip 10.33.48.13
        user-ip 10.1.28.21
        user-ip 10.1.25.23
        user-ip 10.1.28.20
        user-ip 10.0.44.25
        user-ip 10.1.28.18
        user-ip 10.4.23.13
        user-ip 10.3.20.23
        user-ip 10.0.29.24
        user-ip 10.1.60.12
        user-ip 10.1.27.16
        user-ip 10.4.23.21
        user-ip 10.2.20.21
        user-ip 10.32.22.17
        user-ip 10.4.23.24
        user-ip 10.2.27.12
        user-ip 10.1.28.17
        user-ip 10.2.27.15
        user-ip 10.0.22.14
        user-ip 10.4.28.22
        user-ip 10.4.28.11
        user-ip 10.1.28.22
        user-ip 10.1.90.13
        user-ip 10.4.28.12
        user-ip 10.0.31.20
        user-ip 10.1.25.16
        user-ip 10.32.21.20
        user-ip 10.0.22.23
        user-ip 10.5.77.21
        user-ip 10.4.25.10
        user-ip 10.1.23.23
        user-ip 10.2.20.22
        user-ip 10.1.27.15
        user-ip 10.2.27.24
        user-ip 10.2.20.14
        user-ip 10.5.35.18
        user-ip 10.1.22.13
        user-ip 10.1.21.25
        user-ip 10.5.38.14
        user-ip 10.0.21.18
        user-ip 10.0.44.14
        user-ip 10.0.38.23
        user-ip 10.33.48.17
        user-ip 10.4.25.15
        user-ip 10.4.23.11
        user-ip 10.1.27.20
        user-ip 10.5.77.23
        user-ip 10.3.20.13
        user-ip 10.32.23.20
        user-ip 10.33.48.18
        user-ip 10.1.22.12
        user-ip 10.0.21.14
        user-ip 10.1.70.98
        user-ip 10.1.60.18
        user-ip 10.1.28.23
        user-ip 10.0.38.17
        user-ip 10.32.26.19
        user-ip 10.5.38.11
        user-ip 10.33.34.10
        user-ip 10.0.31.13
        user-ip 10.5.35.14
        user-ip 10.0.38.22
        user-ip 10.5.44.23
        user-ip 10.2.27.19
        user-ip 10.1.28.6
        user-ip 10.32.26.16
        user-ip 10.33.34.19
        user-ip 10.33.34.13
        user-ip 10.0.35.22
        user-ip 10.0.35.17
        user-ip 10.2.30.17
        user-ip 10.5.44.19
        user-ip 10.1.28.13
        user-ip 10.0.44.19
        user-ip 10.32.21.21
        user-ip 10.0.31.17
        user-ip 10.33.34.16
        user-ip 10.0.29.18
        user-ip 10.1.60.16
        user-ip 10.4.23.10
        user-ip 10.0.38.14
        user-ip 10.32.22.12
        user-ip 10.1.70.15
        user-ip 10.32.23.10
        user-ip 10.0.26.25
        user-ip 10.1.27.10
        user-ip 10.5.38.23
        user-ip 10.1.28.11
        user-ip 10.4.28.14
        user-ip 10.1.25.13
        user-ip 10.5.35.20
        user-ip 10.4.25.25
        user-ip 10.0.29.11
        user-ip 10.5.77.12
        user-ip 10.0.35.24
        user-ip 10.5.44.12
        user-ip 10.0.22.12
        user-ip 10.2.20.23
        user-ip 10.0.44.11
        user-ip 10.1.27.13
        user-ip 10.0.22.18
        user-ip 10.1.27.3
        user-ip 10.4.23.16
        user-ip 10.33.48.21
        user-ip 10.0.21.11
        user-ip 10.2.20.18
        user-ip 10.1.21.15
        user-ip 10.0.44.10
        user-ip 10.0.21.19
        user-ip 10.2.30.23
        user-ip 10.0.26.22
        user-ip 10.1.27.14
        user-ip 10.5.44.17
        user-ip 10.1.25.15
        user-ip 10.0.29.15
        user-ip 10.5.35.23
        user-ip 10.0.35.15
        user-ip 10.0.22.21
        user-ip 10.5.39.17
        user-ip 10.5.39.16
        user-ip 10.5.39.15
        user-ip 10.5.39.12
        user-ip 10.5.39.25
        user-ip 10.5.39.18
        user-ip 10.5.39.22
        user-ip 10.5.39.23
        user-ip 10.5.39.13
        user-ip 10.5.39.19
        user-ip 10.5.39.21
        user-ip 10.5.39.11
        user-ip 10.5.39.14
        user-ip 10.5.39.10
        user-ip 10.5.39.24
        user-ip 10.5.39.20
    }
    unms {
        connection wss://portal.wispmen.com:443+RlSXgznMLGRFqtBY9F0ohK64LjdZEupHPFTkzhVZTHgAAAAA+allowSelfSignedCertificate
    }
}
system {
    analytics-handler {
        send-analytics-report true
    }
    crash-handler {
        send-crash-report true
    }
    domain-name ubnt
    flow-accounting {
        disable-memory-table
        ingress-capture post-dnat
        interface eth9
        netflow {
            enable-egress {
                engine-id 77
            }
            engine-id 76
            mode daemon
            server 127.0.1.1 {
                port 2055
            }
            timeout {
                expiry-interval 60
                flow-generic 60
                icmp 60
                max-active-life 60
                tcp-fin 10
                tcp-generic 60
                tcp-rst 10
                udp 60
            }
            version 9
        }
        syslog-facility daemon
    }
    host-name Rise-Mentor-ER12
    login {
        user ubnt {
            authentication {
                encrypted-password $5$sW5xKzCE9admZ/4d$O2dDIlLVaa3KKolPks6EffVmxHGARYD.M9ZF/yXJAH5
                plaintext-password ""
            }
            level admin
        }
    }
    name-server 1.1.1.1
    name-server 8.8.8.8
    ntp {
        server 0.ubnt.pool.ntp.org {
        }
        server 1.ubnt.pool.ntp.org {
        }
        server 2.ubnt.pool.ntp.org {
        }
        server 3.ubnt.pool.ntp.org {
        }
    }
    syslog {
        global {
            facility all {
                level notice
            }
            facility protocols {
                level debug
            }
        }
    }
    time-zone America/Indiana/Indianapolis
}
traffic-control {
    optimized-queue {
        policy global
        policy queues
    }
}


/* Warning: Do not remove the following line. */
/* === vyatta-config-version: "config-management@1:conntrack@1:cron@1:dhcp-relay@1:dhcp-server@4:firewall@5:ipsec@5:nat@3:qos@1:quagga@2:suspend@1:system@5:ubnt-l2tp@1:ubnt-pptp@1:ubnt-udapi-server@1:ubnt-unms@2:ubnt-util@1:vrrp@1:vyatta-netflow@1:webgui@1:webproxy@1:zone-policy@1" === */
/* Release version: v2.0.9-hotfix.2.5402463.210511.1317 */

