在项目根目录下执行

```shell
rm -Recurse -Force .\src\main\java\com\icuxika\jextract\*

jextract --source --output .\src\main\java\ -t com.icuxika.jextract.win32 -luser32 -lkernel32 .\jextract\ffm.h "@.\jextract\includes.txt"
```