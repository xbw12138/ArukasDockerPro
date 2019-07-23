package com.xbw.arukas.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StartBean {

    /**
     * statuscode : 202
     * data : {"data":{"id":"88b61fbc-7d26-4078-a407-831bb2f7f816","type":"marathon-apps","attributes":{"uuid":"88b61fbc-7d26-4078-a407-831bb2f7f816","image":"xbw12138/auto-shadowsocks:latest","cpus":0.1,"memory":null,"instances":1,"ports":[{"number":8989,"protocol":"tcp"}],"environment":null,"created-at":"2018-06-02T15:38:55.124Z","updated-at":"2018-07-14T17:04:32.451Z","zone-id":null,"command":"","port-mappings":null,"status":"stopped","subdomain":"elegant-liskov-6435","custom-domain":""},"relationships":{"app":{"data":{"id":"fd0ba114-682e-450e-8849-9d37154e4ca9","type":"apps"}},"running-zone":{"data":null}}}}
     */

    private int statuscode;
    private DataBeanXX data;

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public DataBeanXX getData() {
        return data;
    }

    public void setData(DataBeanXX data) {
        this.data = data;
    }

    public static class DataBeanXX {
        /**
         * data : {"id":"88b61fbc-7d26-4078-a407-831bb2f7f816","type":"marathon-apps","attributes":{"uuid":"88b61fbc-7d26-4078-a407-831bb2f7f816","image":"xbw12138/auto-shadowsocks:latest","cpus":0.1,"memory":null,"instances":1,"ports":[{"number":8989,"protocol":"tcp"}],"environment":null,"created-at":"2018-06-02T15:38:55.124Z","updated-at":"2018-07-14T17:04:32.451Z","zone-id":null,"command":"","port-mappings":null,"status":"stopped","subdomain":"elegant-liskov-6435","custom-domain":""},"relationships":{"app":{"data":{"id":"fd0ba114-682e-450e-8849-9d37154e4ca9","type":"apps"}},"running-zone":{"data":null}}}
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
             * id : 88b61fbc-7d26-4078-a407-831bb2f7f816
             * type : marathon-apps
             * attributes : {"uuid":"88b61fbc-7d26-4078-a407-831bb2f7f816","image":"xbw12138/auto-shadowsocks:latest","cpus":0.1,"memory":null,"instances":1,"ports":[{"number":8989,"protocol":"tcp"}],"environment":null,"created-at":"2018-06-02T15:38:55.124Z","updated-at":"2018-07-14T17:04:32.451Z","zone-id":null,"command":"","port-mappings":null,"status":"stopped","subdomain":"elegant-liskov-6435","custom-domain":""}
             * relationships : {"app":{"data":{"id":"fd0ba114-682e-450e-8849-9d37154e4ca9","type":"apps"}},"running-zone":{"data":null}}
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
                 * uuid : 88b61fbc-7d26-4078-a407-831bb2f7f816
                 * image : xbw12138/auto-shadowsocks:latest
                 * cpus : 0.1
                 * memory : null
                 * instances : 1
                 * ports : [{"number":8989,"protocol":"tcp"}]
                 * environment : null
                 * created-at : 2018-06-02T15:38:55.124Z
                 * updated-at : 2018-07-14T17:04:32.451Z
                 * zone-id : null
                 * command :
                 * port-mappings : null
                 * status : stopped
                 * subdomain : elegant-liskov-6435
                 * custom-domain :
                 */

                private String uuid;
                private String image;
                private double cpus;
                private Object memory;
                private int instances;
                private Object environment;
                @SerializedName("created-at")
                private String createdat;
                @SerializedName("updated-at")
                private String updatedat;
                @SerializedName("zone-id")
                private Object zoneid;
                private String command;
                @SerializedName("port-mappings")
                private Object portmappings;
                private String status;
                private String subdomain;
                @SerializedName("custom-domain")
                private String customdomain;
                private List<String> ports;

                public String getUuid() {
                    return uuid;
                }

                public void setUuid(String uuid) {
                    this.uuid = uuid;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
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

                public int getInstances() {
                    return instances;
                }

                public void setInstances(int instances) {
                    this.instances = instances;
                }

                public Object getEnvironment() {
                    return environment;
                }

                public void setEnvironment(Object environment) {
                    this.environment = environment;
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

                public Object getZoneid() {
                    return zoneid;
                }

                public void setZoneid(Object zoneid) {
                    this.zoneid = zoneid;
                }

                public String getCommand() {
                    return command;
                }

                public void setCommand(String command) {
                    this.command = command;
                }

                public Object getPortmappings() {
                    return portmappings;
                }

                public void setPortmappings(Object portmappings) {
                    this.portmappings = portmappings;
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

                public String getCustomdomain() {
                    return customdomain;
                }

                public void setCustomdomain(String customdomain) {
                    this.customdomain = customdomain;
                }

                public List<String> getPorts() {
                    return ports;
                }

                public void setPorts(List<String> ports) {
                    this.ports = ports;
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
            }

            public static class RelationshipsBean {
                /**
                 * app : {"data":{"id":"fd0ba114-682e-450e-8849-9d37154e4ca9","type":"apps"}}
                 * running-zone : {"data":null}
                 */

                private AppBean app;
                @SerializedName("running-zone")
                private RunningzoneBean runningzone;

                public AppBean getApp() {
                    return app;
                }

                public void setApp(AppBean app) {
                    this.app = app;
                }

                public RunningzoneBean getRunningzone() {
                    return runningzone;
                }

                public void setRunningzone(RunningzoneBean runningzone) {
                    this.runningzone = runningzone;
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

                public static class RunningzoneBean {
                    /**
                     * data : null
                     */

                    private Object data;

                    public Object getData() {
                        return data;
                    }

                    public void setData(Object data) {
                        this.data = data;
                    }
                }
            }
        }
    }
}
