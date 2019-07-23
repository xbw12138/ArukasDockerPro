package com.xbw.arukas.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailBean {

    /**
     * statuscode : 200
     * data : {"data":{"id":"88b61fbc-7d26-4078-a407-831bb2f7f816","type":"services","attributes":{"app-id":"fd0ba114-682e-450e-8849-9d37154e4ca9","image":"xbw12138/auto-shadowsocks:latest","command":"/foo/bash.sh","instances":1,"cpus":0.1,"memory":null,"environment":[{"key":"xx","value":"11"}],"ports":["22/tcp","8989/tcp"],"port-mappings":[[{"container-port":8989,"host":"seaof-163-43-82-143.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31369},{"container-port":80,"host":"seaof-163-43-82-143.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":null}],[{"container-port":8989,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31865},{"container-port":80,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31866}]],"created-at":"2018-06-02T15:38:55.124Z","updated-at":"2018-07-14T16:03:47.104Z","status":"rebooting","subdomain":"elegant-liskov-6435","endpoint":"elegant-liskov-6435.arukascloud.io","custom-domain":"ocr.ecfun.cc","last-instance-failed-at":null,"last-instance-failed-status":null},"relationships":{"app":{"data":{"id":"fd0ba114-682e-450e-8849-9d37154e4ca9","type":"apps"}},"service-plan":{"data":{"id":"jp-tokyo/free","type":"service-plans"}}}}}
     */

    private int statuscode;
    private DataBeanXXX data;

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public DataBeanXXX getData() {
        return data;
    }

    public void setData(DataBeanXXX data) {
        this.data = data;
    }

    public static class DataBeanXXX {
        /**
         * data : {"id":"88b61fbc-7d26-4078-a407-831bb2f7f816","type":"services","attributes":{"app-id":"fd0ba114-682e-450e-8849-9d37154e4ca9","image":"xbw12138/auto-shadowsocks:latest","command":"/foo/bash.sh","instances":1,"cpus":0.1,"memory":null,"environment":[{"key":"xx","value":"11"}],"ports":[{"number":8989,"protocol":"tcp"},{"number":80,"protocol":"tcp"}],"port-mappings":[[{"container-port":8989,"host":"seaof-163-43-82-143.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31369},{"container-port":80,"host":"seaof-163-43-82-143.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":null}],[{"container-port":8989,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31865},{"container-port":80,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31866}]],"created-at":"2018-06-02T15:38:55.124Z","updated-at":"2018-07-14T16:03:47.104Z","status":"rebooting","subdomain":"elegant-liskov-6435","endpoint":"elegant-liskov-6435.arukascloud.io","custom-domain":"ocr.ecfun.cc","last-instance-failed-at":null,"last-instance-failed-status":null},"relationships":{"app":{"data":{"id":"fd0ba114-682e-450e-8849-9d37154e4ca9","type":"apps"}},"service-plan":{"data":{"id":"jp-tokyo/free","type":"service-plans"}}}}
         */

        private DataBeanXX data;

        public DataBeanXX getData() {
            return data;
        }

        public void setData(DataBeanXX data) {
            this.data = data;
        }

        public static class DataBeanXX {
            /**
             * id : 88b61fbc-7d26-4078-a407-831bb2f7f816
             * type : services
             * attributes : {"app-id":"fd0ba114-682e-450e-8849-9d37154e4ca9","image":"xbw12138/auto-shadowsocks:latest","command":"/foo/bash.sh","instances":1,"cpus":0.1,"memory":null,"environment":[{"key":"xx","value":"11"}],"ports":[{"number":8989,"protocol":"tcp"},{"number":80,"protocol":"tcp"}],"port-mappings":[[{"container-port":8989,"host":"seaof-163-43-82-143.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31369},{"container-port":80,"host":"seaof-163-43-82-143.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":null}],[{"container-port":8989,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31865},{"container-port":80,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31866}]],"created-at":"2018-06-02T15:38:55.124Z","updated-at":"2018-07-14T16:03:47.104Z","status":"rebooting","subdomain":"elegant-liskov-6435","endpoint":"elegant-liskov-6435.arukascloud.io","custom-domain":"ocr.ecfun.cc","last-instance-failed-at":null,"last-instance-failed-status":null}
             * relationships : {"app":{"data":{"id":"fd0ba114-682e-450e-8849-9d37154e4ca9","type":"apps"}},"service-plan":{"data":{"id":"jp-tokyo/free","type":"service-plans"}}}
             */

            private String id;
            private String type;
            private AttributesBean attributes;
            private RelationshipsBean relationships;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public AttributesBean getAttributes() {
                return attributes;
            }

            public void setAttributes(AttributesBean attributes) {
                this.attributes = attributes;
            }

            public RelationshipsBean getRelationships() {
                return relationships;
            }

            public void setRelationships(RelationshipsBean relationships) {
                this.relationships = relationships;
            }

            public static class AttributesBean {
                /**
                 * app-id : fd0ba114-682e-450e-8849-9d37154e4ca9
                 * image : xbw12138/auto-shadowsocks:latest
                 * command : /foo/bash.sh
                 * instances : 1
                 * cpus : 0.1
                 * memory : null
                 * environment : [{"key":"xx","value":"11"}]
                 * ports : [{"number":8989,"protocol":"tcp"},{"number":80,"protocol":"tcp"}]
                 * port-mappings : [[{"container-port":8989,"host":"seaof-163-43-82-143.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31369},{"container-port":80,"host":"seaof-163-43-82-143.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":null}],[{"container-port":8989,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31865},{"container-port":80,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31866}]]
                 * created-at : 2018-06-02T15:38:55.124Z
                 * updated-at : 2018-07-14T16:03:47.104Z
                 * status : rebooting
                 * subdomain : elegant-liskov-6435
                 * endpoint : elegant-liskov-6435.arukascloud.io
                 * custom-domain : ocr.ecfun.cc
                 * last-instance-failed-at : null
                 * last-instance-failed-status : null
                 */

                @SerializedName("app-id")
                private String appid;
                private String image;
                private String command;
                private int instances;
                private double cpus;
                private Object memory;
                @SerializedName("created-at")
                private String createdat;
                @SerializedName("updated-at")
                private String updatedat;
                private String status;
                private String subdomain;
                private String endpoint;
                @SerializedName("custom-domain")
                private String customdomain;
                @SerializedName("last-instance-failed-at")
                private Object lastinstancefailedat;
                @SerializedName("last-instance-failed-status")
                private Object lastinstancefailedstatus;
                @SerializedName("last-instance-failed-message")
                private Object lastinstancefailedmessage;
                private List<EnvironmentBean> environment;
                private List<String> ports;
                @SerializedName("port-mappings")
                private List<List<PortmappingsBean>> portmappings;

                public String getAppid() {
                    return appid;
                }

                public void setAppid(String appid) {
                    this.appid = appid;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getCommand() {
                    return command;
                }

                public void setCommand(String command) {
                    this.command = command;
                }

                public int getInstances() {
                    return instances;
                }

                public void setInstances(int instances) {
                    this.instances = instances;
                }

                public double getCpus() {
                    return cpus;
                }

                public void setCpus(double cpus) {
                    this.cpus = cpus;
                }

                public Object getMemory() {
                    return memory;
                }

                public void setMemory(Object memory) {
                    this.memory = memory;
                }

                public String getCreatedat() {
                    return createdat;
                }

                public void setCreatedat(String createdat) {
                    this.createdat = createdat;
                }

                public String getUpdatedat() {
                    return updatedat;
                }

                public void setUpdatedat(String updatedat) {
                    this.updatedat = updatedat;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getSubdomain() {
                    return subdomain;
                }

                public void setSubdomain(String subdomain) {
                    this.subdomain = subdomain;
                }

                public String getEndpoint() {
                    return endpoint;
                }

                public void setEndpoint(String endpoint) {
                    this.endpoint = endpoint;
                }

                public String getCustomdomain() {
                    return customdomain;
                }

                public void setCustomdomain(String customdomain) {
                    this.customdomain = customdomain;
                }

                public Object getLastinstancefailedat() {
                    return lastinstancefailedat;
                }

                public void setLastinstancefailedat(Object lastinstancefailedat) {
                    this.lastinstancefailedat = lastinstancefailedat;
                }

                public Object getLastinstancefailedstatus() {
                    return lastinstancefailedstatus;
                }

                public void setLastinstancefailedstatus(Object lastinstancefailedstatus) {
                    this.lastinstancefailedstatus = lastinstancefailedstatus;
                }
                public Object getLastinstancefailedmessage() {
                    return lastinstancefailedmessage;
                }

                public void setLastinstancefailedmessage(Object lastinstancefailedmessage) {
                    this.lastinstancefailedmessage = lastinstancefailedmessage;
                }
                public List<EnvironmentBean> getEnvironment() {
                    return environment;
                }

                public void setEnvironment(List<EnvironmentBean> environment) {
                    this.environment = environment;
                }

                public List<String> getPorts() {
                    return ports;
                }

                public void setPorts(List<String> ports) {
                    this.ports = ports;
                }

                public List<List<PortmappingsBean>> getPortmappings() {
                    return portmappings;
                }

                public void setPortmappings(List<List<PortmappingsBean>> portmappings) {
                    this.portmappings = portmappings;
                }

                public static class EnvironmentBean {
                    /**
                     * key : xx
                     * value : 11
                     */

                    private String key;
                    private String value;

                    public String getKey() {
                        return key;
                    }

                    public void setKey(String key) {
                        this.key = key;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class PortsBean {
                    /**
                     * number : 8989
                     * protocol : tcp
                     */

                    private int number;
                    private String protocol;

                    public int getNumber() {
                        return number;
                    }

                    public void setNumber(int number) {
                        this.number = number;
                    }

                    public String getProtocol() {
                        return protocol;
                    }

                    public void setProtocol(String protocol) {
                        this.protocol = protocol;
                    }
                }

                public static class PortmappingsBean {
                    /**
                     * container-port : 8989
                     * host : seaof-163-43-82-143.jp-tokyo-01.arukascloud.io
                     * protocol : tcp
                     * service-port : 31369
                     */

                    @SerializedName("container-port")
                    private int containerport;
                    private String host;
                    private String protocol;
                    @SerializedName("service-port")
                    private int serviceport;

                    public int getContainerport() {
                        return containerport;
                    }

                    public void setContainerport(int containerport) {
                        this.containerport = containerport;
                    }

                    public String getHost() {
                        return host;
                    }

                    public void setHost(String host) {
                        this.host = host;
                    }

                    public String getProtocol() {
                        return protocol;
                    }

                    public void setProtocol(String protocol) {
                        this.protocol = protocol;
                    }

                    public int getServiceport() {
                        return serviceport;
                    }

                    public void setServiceport(int serviceport) {
                        this.serviceport = serviceport;
                    }
                }
            }

            public static class RelationshipsBean {
                /**
                 * app : {"data":{"id":"fd0ba114-682e-450e-8849-9d37154e4ca9","type":"apps"}}
                 * service-plan : {"data":{"id":"jp-tokyo/free","type":"service-plans"}}
                 */

                private AppBean app;
                @SerializedName("service-plan")
                private ServiceplanBean serviceplan;

                public AppBean getApp() {
                    return app;
                }

                public void setApp(AppBean app) {
                    this.app = app;
                }

                public ServiceplanBean getServiceplan() {
                    return serviceplan;
                }

                public void setServiceplan(ServiceplanBean serviceplan) {
                    this.serviceplan = serviceplan;
                }

                public static class AppBean {
                    /**
                     * data : {"id":"fd0ba114-682e-450e-8849-9d37154e4ca9","type":"apps"}
                     */

                    private DataBean data;

                    public DataBean getData() {
                        return data;
                    }

                    public void setData(DataBean data) {
                        this.data = data;
                    }

                    public static class DataBean {
                        /**
                         * id : fd0ba114-682e-450e-8849-9d37154e4ca9
                         * type : apps
                         */

                        private String id;
                        private String type;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }
                    }
                }

                public static class ServiceplanBean {
                    /**
                     * data : {"id":"jp-tokyo/free","type":"service-plans"}
                     */

                    private DataBeanX data;

                    public DataBeanX getData() {
                        return data;
                    }

                    public void setData(DataBeanX data) {
                        this.data = data;
                    }

                    public static class DataBeanX {
                        /**
                         * id : jp-tokyo/free
                         * type : service-plans
                         */

                        private String id;
                        private String type;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }
                    }
                }
            }
        }
    }
}
