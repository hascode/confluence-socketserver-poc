# Confluence Socket Server Plugin PoC

Just starts a socket server listening on port 6666.

## Starting the Server Instance

```
atlas-run
```

## Opening a Client Connection

```
% telnet localhost 6666
Trying 127.0.0.1...
Connected to localhost.
Escape character is '^]'.
welcome torsten
hello torsten, now it's 2016-11-08T08:41:45.089+01:00[Europe/Berlin]
hello torsten, now it's 2016-11-08T08:41:55.091+01:00[Europe/Berlin]
```