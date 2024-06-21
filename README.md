This is a project generated with start.spring.io

A REST API for managing filters fron the askend-frontend project. 

Problems I could not overcome due to time restraints: 
1) CORS - dispite adding @CrossOrigin and even implementing a global config I ran out of time to fix it.
2) The api (at least when I was testing it) exposed its resourses at localhost:8080 not localhost:8080/api as @RequestMapping("/api") tag would imply.
