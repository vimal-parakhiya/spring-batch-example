# spring-batch-example
Spring Batch Example demonstrating in-memory and JDBC Spring Batch Repository

By default, in-memory Spring batch repository is used to store Spring batch Job, Step, Execution Context and other information.

JDBC/MySQL based Spring Batch Repository can be enabled using following property in config.env. You need to also modify MySQL DB properties accordingly.
inmemory_batch_repository=false
