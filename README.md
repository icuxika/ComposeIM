# 使用 [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform) desktop application 构建的 IM 应用

## 资源预生成

> 为`src/main/composeResources/drawable`下的图片资源，生成对应的`DrawableResource`
> 变量，然后通过`painterResource(Res.drawable.compose_multiplatform)`方式使用

```shell
gradle generateComposeResClass
```