jersey-spring-ws
================

***Restful CRUD Web Service Example (Jersey + Spring)***

----------------------------------------------------------

API URL: /messages/api/{message_id}

Application uses embedded H2 database

*(with 10 predefined test entries: IDs from 1 to 10).*

*For test can be used for example this REST client <https://rest-client.googlecode.com/> (download <https://rest-client.googlecode.com/files/restclient-ui-3.2.1-jar-with-dependencies.jar>).*

----------------------------------------------------------

***Next types of HTTP requests can be used:***
  * HTTP POST to create new entry
  * HTTP GET to read existent entry
  * HTTP PUT to update existent entry
  * HTTP DELETE to delete entry

**Web service supports JSON and XML format for in/out messages.**

Format of request message should be defined in the HTTP header
"Content-Type". 

***Valid content types are:***

  * Content-Type: application/json
  * Content-Type: application/xml

Desired format of response message should be defined in the HTTP header
"Accept". 

***Valid "Accept" headers are:***
  
  * Accept: application/json
  * Accept: application/xml

***Format of JSON message for POST and PUT operations:***

<pre>
 {"title":"test title","body":"test body","timestamp":1384449994000}
</pre>

**Format of XML message for POST and PUT operations:**

<pre>
&lt;message&gt;
   &lt;title&gt;test title&lt;/title&gt; 
   &lt;body&gt;test body&lt;/body&gt;
   &lt;timestamp&gt;1384449994000&lt;/timestamp&gt;
&lt;/message&gt;
</pre>

-----------------------------------------------------------

**Examples of response messages:**

***JSON response message:***

<pre>
{
   "records":1,
   "operation":"GET",
   "error":"",
   "message":{
      "body":"test body",
      "title":"test title",
      "id":12,
      "timestamp":1384449994000
   },
   "id":12
}      	
</pre>

***XML response message:***

<pre>
&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
&lt;status&gt;
   &lt;error /&gt;
   &lt;id&gt;10&lt;/id&gt;
   &lt;message&gt;
     &lt;body&gt;test body #10&lt;/body&gt;
      &lt;id&gt;10&lt;/id&gt;
     &lt;timestamp&gt;1384449990000&lt;/timestamp&gt;
      &lt;title&gt;test title #10&lt;/title&gt;
   &lt;/message&gt;
   &lt;operation&gt;GET&lt;/operation&gt;
   &lt;records&gt;1&lt;/records&gt;
&lt;/status&gt;
</pre>

***Where:***

  * "records" - is amount of affected entries in the DB.
  * "operation" - is request's HTTP method.
  * "error" - is error message if any. For example:
    org.springframework.dao.EmptyResultDataAccessException: Incorrect
    result size: expected 1, actual 0
  * "message" - is related message (the same domain object as was used
    for request). For GET operation the "message" field contains result.
    For POST and PUT operations the "message" field will be filled by
    the input message object only if an error occurred. Input data will
    be saved in the response for troubleshooting goals.
  * "id" - is the message ID in the DB. For POST operation "id"
    contains ID of new record (or -1 if error occurred), for rest of
    operations "id" is the same as in the input data
    (/messages/api/{message_id}).
