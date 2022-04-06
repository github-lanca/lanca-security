目的：避免重复/过多/冗余的添加maven依赖,参数传递对象，整合抽取该模块
common通用模块【技术通用+业务通用】
技术通用：
1。[pojo]所有对象，通用的vo对象，统一的返回对象，供所有模块使用R，各种对象（复用）
2。[sql]基础的Sql包功能，供所有模块使用（mybatis-plus/mysql-connector-java/driver）（避免其他模块使用时，再次添加maven坐标）
3。[swagger-ui]通用swagger模块，供其他模块使用
5。[redis]第三方缓存中间件/redis/cache/messages/rabbitmq/rocketmq（按道理都应该整合到技术通用模块中去）
    由于已经存在，即按需添加坐标使用，
6.[rabbtimq]
业务通用：
1。通用日志记录模块（所有模块都需要都日志功能/基础业务功能）
2.[security] 安全模块
