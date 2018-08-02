# hdf-service

## Intellij Configuration


### Live reload
https://www.romaniancoder.com/spring-boot-live-reload-with-intellij/

* You need to enable the “Make project automatically” option. You can find it in Settings – Build, Execution, Deployment – Compiler
* To open the registry, just press SHIFT+CTRL+A. In the pop-up window, type registry and go to this option. In the registry window, enable the “compiler.automake.allow.when.app.running” check-box.
 

### Start App
```bash
$ mvn clean spring-boot:run 
```

### Configuration

#### Password encryption
https://github.com/ulisesbocchio/jasypt-spring-boot

