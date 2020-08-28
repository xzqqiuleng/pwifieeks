package com.peek.camera.model;

public class TianAddrInfo {
    private String msg;
    private ResultBean result;
    private String status;

    public static class ResultBean {
        private AddressComponentBean addressComponent;
        private String formatted_address;
        private LocationBean location;

        public static class AddressComponentBean {
            private String address;
            private int address_distance;
            private String address_position;
            private String city;
            private String poi;
            private String poi_distance;
            private String poi_position;
            private String road;
            private int road_distance;

            public String getAddress() {
                return this.address;
            }

            public int getAddress_distance() {
                return this.address_distance;
            }

            public String getAddress_position() {
                return this.address_position;
            }

            public String getCity() {
                return this.city;
            }

            public String getPoi() {
                return this.poi;
            }

            public String getPoi_distance() {
                return this.poi_distance;
            }

            public String getPoi_position() {
                return this.poi_position;
            }

            public String getRoad() {
                return this.road;
            }

            public int getRoad_distance() {
                return this.road_distance;
            }

            public void setAddress(String str) {
                this.address = str;
            }

            public void setAddress_distance(int i) {
                this.address_distance = i;
            }

            public void setAddress_position(String str) {
                this.address_position = str;
            }

            public void setCity(String str) {
                this.city = str;
            }

            public void setPoi(String str) {
                this.poi = str;
            }

            public void setPoi_distance(String str) {
                this.poi_distance = str;
            }

            public void setPoi_position(String str) {
                this.poi_position = str;
            }

            public void setRoad(String str) {
                this.road = str;
            }

            public void setRoad_distance(int i) {
                this.road_distance = i;
            }
        }

        public static class LocationBean {
            private double lat;
            private double lon;

            public double getLat() {
                return this.lat;
            }

            public double getLon() {
                return this.lon;
            }

            public void setLat(double d) {
                this.lat = d;
            }

            public void setLon(double d) {
                this.lon = d;
            }
        }

        public AddressComponentBean getAddressComponent() {
            return this.addressComponent;
        }

        public String getFormatted_address() {
            return this.formatted_address;
        }

        public LocationBean getLocation() {
            return this.location;
        }

        public void setAddressComponent(AddressComponentBean addressComponentBean) {
            this.addressComponent = addressComponentBean;
        }

        public void setFormatted_address(String str) {
            this.formatted_address = str;
        }

        public void setLocation(LocationBean locationBean) {
            this.location = locationBean;
        }
    }

    public String getMsg() {
        return this.msg;
    }

    public ResultBean getResult() {
        return this.result;
    }

    public String getStatus() {
        return this.status;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setResult(ResultBean resultBean) {
        this.result = resultBean;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
