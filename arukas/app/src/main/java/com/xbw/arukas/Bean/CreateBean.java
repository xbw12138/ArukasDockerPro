package com.xbw.arukas.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateBean {


    /**
     * statuscode : 200
     * data : {"data":{"id":"837ff771-8db5-48cf-a40c-dae9fc37e59d","type":"apps","attributes":{"name":"myapp","created-at":"2018-02-12T18:28:33.721Z","updated-at":"2018-02-12T18:28:33.721Z"},"relationships":{"user":{"data":{"id":"72e00ac7-19a8-42da-b35a-43bdf812b461","type":"users"}},"services":{"data":[{"id":"7022a19e-ba83-42eb-a608-ff5ae272a12a","type":"services"}]}}},"included":[{"id":"7022a19e-ba83-42eb-a608-ff5ae272a12a","type":"services","attributes":{"app-id":"837ff771-8db5-48cf-a40c-dae9fc37e59d","image":"nginx","command":"","instances":1,"cpus":0.1,"memory":null,"environment":[{"key":"key1","value":"value2"},{"key":"key2","value":"value2"}],"ports":[{"number":80,"protocol":"tcp"},{"number":443,"protocol":"tcp"}],"port-mappings":null,"created-at":"2018-02-12T18:28:33.751Z","updated-at":"2018-02-12T18:28:33.751Z","status":"stopped","subdomain":"example","endpoint":"example.arukascloud.io","custom-domain":null,"last-instance-failed-at":null,"last-instance-failed-status":null},"relationships":{"app":{"data":{"id":"837ff771-8db5-48cf-a40c-dae9fc37e59d","type":"apps"}},"service-plan":{"data":{"id":"jp-tokyo/hobby","type":"service-plans"}}}},{"id":"jp-tokyo/hobby","type":"service-plans","attributes":{"code":"jp-tokyo_hobby_v1","name":"Hobby","region-id":1,"version":1,"cpus":"0.1","memory":512,"price":450,"created-at":"2018-02-12T16:45:24.205Z","updated-at":"2018-02-12T16:45:24.205Z"},"relationships":{"region":{"data":{"id":"1","type":"regions"}}}}]}
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
        /**
         * data : {"id":"837ff771-8db5-48cf-a40c-dae9fc37e59d","type":"apps","attributes":{"name":"myapp","created-at":"2018-02-12T18:28:33.721Z","updated-at":"2018-02-12T18:28:33.721Z"},"relationships":{"user":{"data":{"id":"72e00ac7-19a8-42da-b35a-43bdf812b461","type":"users"}},"services":{"data":[{"id":"7022a19e-ba83-42eb-a608-ff5ae272a12a","type":"services"}]}}}
         * included : [{"id":"7022a19e-ba83-42eb-a608-ff5ae272a12a","type":"services","attributes":{"app-id":"837ff771-8db5-48cf-a40c-dae9fc37e59d","image":"nginx","command":"","instances":1,"cpus":0.1,"memory":null,"environment":[{"key":"key1","value":"value2"},{"key":"key2","value":"value2"}],"ports":[{"number":80,"protocol":"tcp"},{"number":443,"protocol":"tcp"}],"port-mappings":null,"created-at":"2018-02-12T18:28:33.751Z","updated-at":"2018-02-12T18:28:33.751Z","status":"stopped","subdomain":"example","endpoint":"example.arukascloud.io","custom-domain":null,"last-instance-failed-at":null,"last-instance-failed-status":null},"relationships":{"app":{"data":{"id":"837ff771-8db5-48cf-a40c-dae9fc37e59d","type":"apps"}},"service-plan":{"data":{"id":"jp-tokyo/hobby","type":"service-plans"}}}},{"id":"jp-tokyo/hobby","type":"service-plans","attributes":{"code":"jp-tokyo_hobby_v1","name":"Hobby","region-id":1,"version":1,"cpus":"0.1","memory":512,"price":450,"created-at":"2018-02-12T16:45:24.205Z","updated-at":"2018-02-12T16:45:24.205Z"},"relationships":{"region":{"data":{"id":"1","type":"regions"}}}}]
         */

        private DataBeanXX data;
        private List<IncludedBean> included;

        public DataBeanXX getData() {
            return data;
        }

        public void setData(DataBeanXX data) {
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
             * id : 837ff771-8db5-48cf-a40c-dae9fc37e59d
             * type : apps
             * attributes : {"name":"myapp","created-at":"2018-02-12T18:28:33.721Z","updated-at":"2018-02-12T18:28:33.721Z"}
             * relationships : {"user":{"data":{"id":"72e00ac7-19a8-42da-b35a-43bdf812b461","type":"users"}},"services":{"data":[{"id":"7022a19e-ba83-42eb-a608-ff5ae272a12a","type":"services"}]}}
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
                 * name : myapp
                 * created-at : 2018-02-12T18:28:33.721Z
                 * updated-at : 2018-02-12T18:28:33.721Z
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
                 * user : {"data":{"id":"72e00ac7-19a8-42da-b35a-43bdf812b461","type":"users"}}
                 * services : {"data":[{"id":"7022a19e-ba83-42eb-a608-ff5ae272a12a","type":"services"}]}
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
                     * data : {"id":"72e00ac7-19a8-42da-b35a-43bdf812b461","type":"users"}
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
                         * id : 72e00ac7-19a8-42da-b35a-43bdf812b461
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
                         * id : 7022a19e-ba83-42eb-a608-ff5ae272a12a
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
             * id : 7022a19e-ba83-42eb-a608-ff5ae272a12a
             * type : services
             * attributes : {"app-id":"837ff771-8db5-48cf-a40c-dae9fc37e59d","image":"nginx","command":"","instances":1,"cpus":0.1,"memory":null,"environment":[{"key":"key1","value":"value2"},{"key":"key2","value":"value2"}],"ports":[{"number":80,"protocol":"tcp"},{"number":443,"protocol":"tcp"}],"port-mappings":null,"created-at":"2018-02-12T18:28:33.751Z","updated-at":"2018-02-12T18:28:33.751Z","status":"stopped","subdomain":"example","endpoint":"example.arukascloud.io","custom-domain":null,"last-instance-failed-at":null,"last-instance-failed-status":null}
             * relationships : {"app":{"data":{"id":"837ff771-8db5-48cf-a40c-dae9fc37e59d","type":"apps"}},"service-plan":{"data":{"id":"jp-tokyo/hobby","type":"service-plans"}}}
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
                 * app-id : 837ff771-8db5-48cf-a40c-dae9fc37e59d
                 * image : nginx
                 * command :
                 * instances : 1
                 * cpus : 0.1
                 * memory : null
                 * environment : [{"key":"key1","value":"value2"},{"key":"key2","value":"value2"}]
                 * ports : [{"number":80,"protocol":"tcp"},{"number":443,"protocol":"tcp"}]
                 * port-mappings : null
                 * created-at : 2018-02-12T18:28:33.751Z
                 * updated-at : 2018-02-12T18:28:33.751Z
                 * status : stopped
                 * subdomain : example
                 * endpoint : example.arukascloud.io
                 * custom-domain : null
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
                @SerializedName("port-mappings")
                private Object portmappings;
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
                private List<EnvironmentBean> environment;
                private List<String> ports;

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

                public Object getPortmappings() {
                    return portmappings;
                }

                public void setPortmappings(Object portmappings) {
                    this.portmappings = portmappings;
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

                public static class EnvironmentBean {
                    /**
                     * key : key1
                     * value : value2
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
                     * number : 80
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

            public static class RelationshipsBeanX {
                /**
                 * app : {"data":{"id":"837ff771-8db5-48cf-a40c-dae9fc37e59d","type":"apps"}}
                 * service-plan : {"data":{"id":"jp-tokyo/hobby","type":"service-plans"}}
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
                     * data : {"id":"837ff771-8db5-48cf-a40c-dae9fc37e59d","type":"apps"}
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
                         * id : 837ff771-8db5-48cf-a40c-dae9fc37e59d
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
                     * data : {"id":"jp-tokyo/hobby","type":"service-plans"}
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
                         * id : jp-tokyo/hobby
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
