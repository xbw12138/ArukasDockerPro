package com.xbw.arukas.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllappBean {

    /**
     * statuscode : 200
     * data : {"data":[{"id":"16ab111a-d271-44ba-9625-06bb55ca0ade","type":"apps","attributes":{"name":"ss","created-at":"2018-09-18T12:55:17.386Z","updated-at":"2018-09-18T12:55:17.386Z"},"relationships":{"user":{"data":{"id":"452c8fea-091b-4bc1-bd0f-e29b80cf80a7","type":"users"}},"services":{"data":[{"id":"e5a052ab-2bb8-4e6d-9962-5f6cd8260c08","type":"services"}]}}}],"included":[{"id":"e5a052ab-2bb8-4e6d-9962-5f6cd8260c08","type":"services","attributes":{"app-id":"16ab111a-d271-44ba-9625-06bb55ca0ade","image":"xbw12138/auto-shadowsocks:latest","command":null,"instances":1,"cpus":0.1,"memory":null,"environment":null,"ports":["22/tcp","8989/tcp"],"port-mappings":[[{"container-port":22,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31514},{"container-port":8989,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31515}]],"created-at":"2018-09-18T12:55:17.411Z","updated-at":"2018-09-18T12:55:54.375Z","status":"running","subdomain":"boring-booth-9948","endpoint":"boring-booth-9948.arukascloud.io","custom-domain":null,"last-instance-failed-at":null,"last-instance-failed-status":null,"last-instance-failed-message":null},"relationships":{"app":{"data":{"id":"16ab111a-d271-44ba-9625-06bb55ca0ade","type":"apps"}},"service-plan":{"data":{"id":"jp-tokyo/free","type":"service-plans"}}}}]}
     */

    private int statuscode;
    private DataBeanXXXXX data;

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public DataBeanXXXXX getData() {
        return data;
    }

    public void setData(DataBeanXXXXX data) {
        this.data = data;
    }

    public static class DataBeanXXXXX {
        private List<DataBeanXX> data;
        private List<IncludedBean> included;

        public List<DataBeanXX> getData() {
            return data;
        }

        public void setData(List<DataBeanXX> data) {
            this.data = data;
        }

        public List<IncludedBean> getIncluded() {
            return included;
        }

        public void setIncluded(List<IncludedBean> included) {
            this.included = included;
        }

        public static class DataBeanXX {
            /**
             * id : 16ab111a-d271-44ba-9625-06bb55ca0ade
             * type : apps
             * attributes : {"name":"ss","created-at":"2018-09-18T12:55:17.386Z","updated-at":"2018-09-18T12:55:17.386Z"}
             * relationships : {"user":{"data":{"id":"452c8fea-091b-4bc1-bd0f-e29b80cf80a7","type":"users"}},"services":{"data":[{"id":"e5a052ab-2bb8-4e6d-9962-5f6cd8260c08","type":"services"}]}}
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
                 * name : ss
                 * created-at : 2018-09-18T12:55:17.386Z
                 * updated-at : 2018-09-18T12:55:17.386Z
                 */

                private String name;
                @SerializedName("created-at")
                private String createdat;
                @SerializedName("updated-at")
                private String updatedat;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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
            }

            public static class RelationshipsBean {
                /**
                 * user : {"data":{"id":"452c8fea-091b-4bc1-bd0f-e29b80cf80a7","type":"users"}}
                 * services : {"data":[{"id":"e5a052ab-2bb8-4e6d-9962-5f6cd8260c08","type":"services"}]}
                 */

                private UserBean user;
                private ServicesBean services;

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public ServicesBean getServices() {
                    return services;
                }

                public void setServices(ServicesBean services) {
                    this.services = services;
                }

                public static class UserBean {
                    /**
                     * data : {"id":"452c8fea-091b-4bc1-bd0f-e29b80cf80a7","type":"users"}
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
                         * id : 452c8fea-091b-4bc1-bd0f-e29b80cf80a7
                         * type : users
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

                public static class ServicesBean {
                    private List<DataBeanX> data;

                    public List<DataBeanX> getData() {
                        return data;
                    }

                    public void setData(List<DataBeanX> data) {
                        this.data = data;
                    }

                    public static class DataBeanX {
                        /**
                         * id : e5a052ab-2bb8-4e6d-9962-5f6cd8260c08
                         * type : services
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

        public static class IncludedBean {
            /**
             * id : e5a052ab-2bb8-4e6d-9962-5f6cd8260c08
             * type : services
             * attributes : {"app-id":"16ab111a-d271-44ba-9625-06bb55ca0ade","image":"xbw12138/auto-shadowsocks:latest","command":null,"instances":1,"cpus":0.1,"memory":null,"environment":null,"ports":["22/tcp","8989/tcp"],"port-mappings":[[{"container-port":22,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31514},{"container-port":8989,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31515}]],"created-at":"2018-09-18T12:55:17.411Z","updated-at":"2018-09-18T12:55:54.375Z","status":"running","subdomain":"boring-booth-9948","endpoint":"boring-booth-9948.arukascloud.io","custom-domain":null,"last-instance-failed-at":null,"last-instance-failed-status":null,"last-instance-failed-message":null}
             * relationships : {"app":{"data":{"id":"16ab111a-d271-44ba-9625-06bb55ca0ade","type":"apps"}},"service-plan":{"data":{"id":"jp-tokyo/free","type":"service-plans"}}}
             */

            private String id;
            private String type;
            private AttributesBeanX attributes;
            private RelationshipsBeanX relationships;

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

            public AttributesBeanX getAttributes() {
                return attributes;
            }

            public void setAttributes(AttributesBeanX attributes) {
                this.attributes = attributes;
            }

            public RelationshipsBeanX getRelationships() {
                return relationships;
            }

            public void setRelationships(RelationshipsBeanX relationships) {
                this.relationships = relationships;
            }

            public static class AttributesBeanX {
                /**
                 * app-id : 16ab111a-d271-44ba-9625-06bb55ca0ade
                 * image : xbw12138/auto-shadowsocks:latest
                 * command : null
                 * instances : 1
                 * cpus : 0.1
                 * memory : null
                 * environment : null
                 * ports : ["22/tcp","8989/tcp"]
                 * port-mappings : [[{"container-port":22,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31514},{"container-port":8989,"host":"seaof-163-43-82-140.jp-tokyo-01.arukascloud.io","protocol":"tcp","service-port":31515}]]
                 * created-at : 2018-09-18T12:55:17.411Z
                 * updated-at : 2018-09-18T12:55:54.375Z
                 * status : running
                 * subdomain : boring-booth-9948
                 * endpoint : boring-booth-9948.arukascloud.io
                 * custom-domain : null
                 * last-instance-failed-at : null
                 * last-instance-failed-status : null
                 * last-instance-failed-message : null
                 */

                @SerializedName("app-id")
                private String appid;
                private String image;
                private Object command;
                private int instances;
                private double cpus;
                private Object memory;
                private Object environment;
                @SerializedName("created-at")
                private String createdat;
                @SerializedName("updated-at")
                private String updatedat;
                private String status;
                private String subdomain;
                private String endpoint;
                @SerializedName("custom-domain")
                private Object customdomain;
                @SerializedName("last-instance-failed-at")
                private Object lastinstancefailedat;
                @SerializedName("last-instance-failed-status")
                private Object lastinstancefailedstatus;
                @SerializedName("last-instance-failed-message")
                private Object lastinstancefailedmessage;
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

                public Object getCommand() {
                    return command;
                }

                public void setCommand(Object command) {
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

                public Object getCustomdomain() {
                    return customdomain;
                }

                public void setCustomdomain(Object customdomain) {
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

                public static class PortmappingsBean {
                    /**
                     * container-port : 22
                     * host : seaof-163-43-82-140.jp-tokyo-01.arukascloud.io
                     * protocol : tcp
                     * service-port : 31514
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

            public static class RelationshipsBeanX {
                /**
                 * app : {"data":{"id":"16ab111a-d271-44ba-9625-06bb55ca0ade","type":"apps"}}
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
                     * data : {"id":"16ab111a-d271-44ba-9625-06bb55ca0ade","type":"apps"}
                     */

                    private DataBeanXXX data;

                    public DataBeanXXX getData() {
                        return data;
                    }

                    public void setData(DataBeanXXX data) {
                        this.data = data;
                    }

                    public static class DataBeanXXX {
                        /**
                         * id : 16ab111a-d271-44ba-9625-06bb55ca0ade
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

                    private DataBeanXXXX data;

                    public DataBeanXXXX getData() {
                        return data;
                    }

                    public void setData(DataBeanXXXX data) {
                        this.data = data;
                    }

                    public static class DataBeanXXXX {
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
