hibernate_search_solr_integration
=================================

Example of how to integrate hibernate search and solr together.
All you need to do is:
1. Download solr server from: http://www.apache.org/dyn/closer.cgi/lucene/solr/4.0.0
2. Open the zip to some folder (lets call it X).
3. Edit the X/example/solr/collection1/conf/schema.xml and add the following lines:
   <!-- My fields-->
   <field name="id" type="int" indexed="true" stored="true" required="true" multiValued="false"/>
   <field name="_hibernate_class" type="text_general" indexed="true" stored="true"/>
   <field name="name" type="string" indexed="true" stored="true"/>
   <field name="comments" type="text_general" indexed="true" stored="true"/>
   <field name="age" type="int" indexed="true" stored="true"/>
4. Comment the predefined fields name, id and comment in schema.xml file
5. Remove the elevate.xml file from X/example/solr/collection1/conf (it preloads bad data)
6. go to X/example and run java -jar start.jar
7. mvn install (in the project's folder)
7. Now you need to run the PersonCRUDMain program (mvn exec:java) and go check the solr document at http://localhost:8983/solr/#/collection1/query
8. You can change the wt parameter to json to see the results in a more clear format.
Enjoy,
  Avner