# sbt-plugin-test
repro for https://github.com/sbt/sbt/issues/4852

add this to `~/.sbt/global.sbt`

```
credentials ++= Seq(
  Credentials("Sonatype Nexus Repository Manager", "167.71.68.47", "test", "test")
)
```

(you also have the rights to publish to that nexus)

reproduce by running the `testproject` with `1.2.8` and `1.3.0-RC4`

```bash
cd testproject
# make sure any 1.2.x cache files are removed
rm -rf ~/.ivy2/cache/scala_2.12/sbt_1.0/com.example/sbt-plugin-test
rm -rf ~/.coursier/cache/v1/http/167.71.68.47%3A8081/
sbt hello
```

even normal dependencies fail

```bash
cd testproject
#comment out the addSbtPlugin in ./project/plugins.sbt
#comment out the .enablePlugins(HelloPlugin) in ./build.sbt
rm -rf ~/.ivy2/cache/scala_2.12/sbt_1.0/com.example/libproject
rm -rf ~/.coursier/cache/v1/http/167.71.68.47%3A8081/
sbt clean run
```
