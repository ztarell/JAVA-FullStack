JDBC
Overview

JDBC, or Java Database Connectivity, is a Java API for connecting to databases. It was first released in 1997 and has been continually refined since. JDBC is a collection of interfaces, classes, and abstract classes that provide a consistent way of connecting to relational databases, regardless of who is providing the database.

It is common to manage database connectivity with an ORM (object-relationship manager) or other convenience library. These tools cut down on code, give us new ways to reason about the database's relationship to our Java code, and can make our lives easier. Underneath it all, though, ORMs and database libraries use JDBC, so there is value in understanding how JDBC works.
Why JDBC?

Before JDBC, each database had its own API – network protocols, metaphors, and conventions – to store and retrieve data from their database. If you ever needed to change the database system used in an application, it was a long process to rewrite all the code necessary to correctly communicate with the new system. JDBC is the solution to that problem.

Database vendors now provide a driver for their database that implements the JDBC interface. As a developer, that means we don't necessarily need to worry about the minutiae of how to connect and communicate with the database. Also, if we need to switch to a new database, it can be as simple as changing the driver we are using to connect.
Concepts

There are several pieces of the JDBC API that we use over and over again that are useful to know about.
Connection

interface: Oracle Docs: Connection (Links to an external site.)

The Connection remembers what and who are connected to the database. It passes queries and data back and forth between the database and the program. We typically open up a Connection, use it for many operations and then close it when we are completely finished; it is inefficient to continually open new connections to the database.
Statement

interface: Oracle Docs: Statement (Links to an external site.)

A Statement represents a single SQL query to the database. It can be any valid SQL query and is typically built as a String. However, because it is built as a String, it can be prone to SQL injection attacks if there is any user input, so we typically use Prepared Statements instead.
Prepared Statement

interface: Oracle Docs: Prepared Statement (Links to an external site.)

A Prepared Statement is a single SQL query that can use dynamic parameters. The parameters are added into the query in such a way that they are sanitized, which prevents SQL injection attacks. Prepared Statements can be for any valid SQL query.
ResultSet

interface: Oracle Docs: ResultSet (Links to an external site.)

A ResultSet holds the data that comes back from a SELECT query. You step through the ResultSet one row at a time to process the data returned from the query.
DriverManager

class: Oracle Docs: DriverManager (Links to an external site.)

The DriverManager is the class that helps pick up the database driver you need to use to create a Connection. However, the DriverManger isn't used as much today, since the DataSource was added.
DataSource

interface: Oracle Docs: DataSource (Links to an external site.)

The DataSource lets us create a Connection to the database of our choice and picks up the correct driver for it. It allows for several behind-the-scenes improvements to Connection handling that make working with the database even better in larger systems.

Summary

JDBC is the technology underneath any piece of Java software that connects up to a database. While most will not be using straight JDBC like we have looked at here, at some level these are the actions taking place.