When Camel meets cdi
--------------------

This reporitory contains code presented during ApacheCon EU 2012.

  - [simple-cdi](simple-cdi) First project with basic service and servlet. 
  - [demo1](demo1) Camel route with timer endpoint and CDI bean invocation + unit test.
  - [demo2](demo2) Camel http transport servlet plus route calling EJB bean.

All these demos are packaged as WAR files after instalation (please use maven for building). For Tom EE use profile 'tomee'.

# Launching examples #
To run examples you might use any JEE 6 compatible server with Web Profile compability. Examples were tested with [JBoss SwitchYard](http://switchyard.org) 0.6.

Known problems:
  - Tom EE 1.5 (Web Profile) doesn't like demo1 decorator call. It doesn't like demo2 either and throws UnknownContainerException. Simple demo goes well.
  - Glassfish 3.1.2 (Web Profile) doesn't like decorators. Deploys well without it. Second demo doesn't work. Even simple demo doesn't work.


Camel used in examples 2.11-SNAPSHOT.

