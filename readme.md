IT Orders Modding
=======================

start the case

```sh
curl -u donato:donato -X POST "http://localhost:8080/kie-server/services/rest/server/containers/it-orders-modding_1.0.0-SNAPSHOT/cases/itorders.orderhardware/instances" -H  "accept: application/json" -H  "content-type: application/json" -d "{    \"case-data\": {        \"order\": {            \"org.jbpm.demo.itorders.Order\": {                \"amount\": 4000            }        }    },    \"case-user-assignments\": {        \"owner\": \"donato\",        \"manager\": \"donato\"    },    \"case-group-assignments\": {}}"
```