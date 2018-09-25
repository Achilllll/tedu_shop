# tedu_shop
tedu_shop,组员记得查看readme文件

dao 数据库交互层
service逻辑层
servlet控制层（和页面交互）
entity 实体类（你们不用管）
Vo value object里面的类在写购物车的时候你们可能会用到
utils 包里有一些通用的方法你们可以去看看 PageModle 和 ResponseResult 你们能会用来包装分页对象和通用返回对象
db.properites 里面是数据库配置 用户密码改成你自己的

tedu_store_2018_9_26.sql是数据库脚本 你们可以导入， 我用的数据库名是tedu_shop

浏览目录，我主要写的文件都在dao里面,要你们做的工作是往service层添加控制逻辑
servlet 使用@webservlet注解指定页面的访问路径（路由），主要做页面的交互工作

xxxdaoImpl 是你们要在service层里写逻辑的时候调用的类，用于数据库连接，具体的api查看具体接口
调用方法如下：
AddressDao addressDao=new AddressDaoImpl();

address.xxxmethod

最后静态页面要改成jsp文件才行，具体你们自己百度吧
建议你们完成一个功能做下测试，在test目录下，具体看我之前写的

给你们每个人开了个分支记得clone你们自己的分支
