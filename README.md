# sbt-child-project-example


- [medium post](https://medium.com/@linda0511ny/sub-project-management-via-sbt-26e9f7bccbad) come with this


- A parent project with a child project inside.
- Parent's class depends on trait inside child.
- Parent's test class depends on trait inside child's test.
- Only publish artifactory from child project. `sbt child/publish`
- Release a fat jar for parent via `sbt assembly`
