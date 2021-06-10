In Step 0, all we have a is a gradle project containing 4 sub-proojects.

We can build the four projects and run their tests, all of which currently test nothing.

We have a github action installed that will build it all and run the tests on every push.

### rwu

This is the utility project, a kotlin library. It will ultimately contain any shared code used by both client and server.
In particular, we expect it to have value objects (data classes) representing the various messages, with JSON in and JSON out operations.

### rws

This is the server project. It will contain the server domain classes, and the main loop for running the server, doing the transport, and so on.

### rwc

This is the client project. It will contain the client UI and domain classes.

### rwm

This is the maker project. It is a "recombination" of the code in all three other projects. It is not a shipping product, but a handy development lab for the makers.
