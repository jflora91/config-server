# config-server
Hierarchical json configuration management for multitenant environments

---
### Data Modeling

|Config|
|-|
|ID|
|Version|
|Data|
|Tenant|
|Date_Create|

* ID: Identify the new entrance

* Version: Identify the new *JSON* update

* Data: Is the concrete *JSON* data that differs from the *BASE JSON*

* Tenant: The tenant being served

* Date_Create: Keep the information when this version was created


