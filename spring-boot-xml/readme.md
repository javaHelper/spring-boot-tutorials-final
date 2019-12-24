curl -X POST \
  http://localhost:8080/rest/save-cust-info \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/xml' \
  -H 'postman-token: fae7a6c7-9aa6-fb02-0ba6-d65b1a3a60cb' \
  -d '<?xml version="1.0" encoding="UTF-8"?>
<customer>
    <country>United States</country>
    <custNo>100</custNo>
    <name>Google</name>
</customer>' 


# Request

http://localhost:8080/rest/cities

```
<Cities>
    <City id="1">
        <name>Bratislava</name>
        <population>432000</population>
    </City>
    <City id="2">
        <name>Budapest</name>
        <population>1759000</population>
    </City>
    <City id="3">
        <name>Prague</name>
        <population>1280000</population>
    </City>
    <City id="4">
        <name>Warsaw</name>
        <population>1748000</population>
    </City>
    <City id="5">
        <name>Los Angeles</name>
        <population>3971000</population>
    </City>
    <City id="6">
        <name>New York</name>
        <population>8550000</population>
    </City>
    <City id="7">
        <name>Edinburgh</name>
        <population>464000</population>
    </City>
    <City id="8">
        <name>Berlin</name>
        <population>3671000</population>
    </City>
</Cities>
```
 
