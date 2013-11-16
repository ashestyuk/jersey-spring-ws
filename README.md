jersey-spring-ws
================

Restful CRUD Web Service Example (Jersey + Spring)

----------------------------------------------------------

API URL: /messages/api/{message_id}
Application uses embedded H2 database 
(with 10 predefined test entries: IDs from 1 to 10).

For test can be used for example this REST client <https://rest-client.googlecode.com/> 
(download <https://rest-client.googlecode.com/files/restclient-ui-3.2.1-jar-with-dependencies.jar>).

Next types of HTTP requests can be used:
  * HTTP POST to create new entry
  * HTTP GET to read existent entry
  * HTTP PUT to update existent entry
  * HTTP DELETE to delete entry

Web service supports JSON and XML format for in/out messages.
Format of request message should be defined in the HTTP header
"Content-Type". Valid content types are:

  Content-Type: application/json
  Content-Type: application/xml

Desired format of response message should be defined in the HTTP header
"Accept". Valid "Accept" headers are:

  Accept: application/json
  Accept: application/xml


Format of JSON message for POST and PUT operations:
	{"title":"test title","body":"test	body","timestamp":1384449994000}

Format of XML message for POST and PUT operations:
	<message>
	   <title>test title</title> 
	   <body>test body</body>
	   <timestamp>1384449994000</timestamp>
	</message>

Examples of response messages:

JSON response message:
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

XML response message:
	<?xml version="1.0" encoding="UTF-8"?>
	<status>
	   <error />
	   <id>10</id>
	   <message>
	     <body>test body #10</body>
	      <id>10</id>
	     <timestamp>1384449990000</timestamp>
	      <title>test title #10</title>
	   </message>
	   <operation>GET</operation>
	   <records>1</records>
	</status>

Where:

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
