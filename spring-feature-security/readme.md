1. oauth2，使用时，也需要使用spring security 进行登录控制
2. oauth2 配置有两个端口进行配置
    1. AuthorizationServerConfigurerAdapter + @EnableAuthorizationServer
        1. 配置oauth的主要入口
        2. 配置ClientDetailsServer、userDetailsService、tokenStore、tokenServices、authenticationManager等
    2. ResourceServerConfigurerAdapter + @EnableResourceServer
        1. 此处配置spring security
        2. 配置resources资源。全局的异常处理，token提取规则，当前服务的resourceid等
        3. 可以在此处配置全局异常处理，来处理鉴权失败后的响应
3. 组件解释
    1. **tokenStore**：存储oauth2生成的token的位置，默认是InMemoryTokenStore
        1. 此处可以做token定时刷新，当一个请求进来后，重置token失效时间
        2. 定义tokenStore可以实现大部分功能。比如redis存储token位置。
    2. **TokenServices**：程序访问token的入口，程序一般不直接访问tokenStore.
        1. 默认是DefaultTokenServices
        2.
        DefaultTokenServices持有authenticationManager，accessTokenEnhancer，clientDetailsService。如果对以上都有自定义的需求，可以自定义tokenServers来实现，不需要重复配置
        3. DefaultTokenServices整合了三家的token处理工作
            1. AuthorizationServerTokenServices
            2. ResourceServerTokenServices
            3. ConsumerTokenServices
    3. **UserDetails**：spring security的用户对象
        1. 判断用户是否生效
        2. 存储用户权限列表
        3. 根据用户名获取授权对象
    4. **ClientDetails**：oauth2的授权主体。默认BaseClientDetails
        1. 存储授权的client的基本信息，权限范围，授权方式，resourceid等
        2. 可以控制生成的token有效时间。access_token和refresh_token
    5. **UserDetailsService**：userDetail在框架中被获取的接口
        1. 在使用默认的authenticationManager(默认是ProviderManager)时，调用该类获取userDetail的进行密码认证
        2. ProviderManager-->DaoAuthenticationProvider--->userDetail
    6. **ClientDetailsServer**：oauth2获取clientDetail的服务
        1. 默认是InMemoryClientDetailsService
        2. 设置自定义的ClientDetailsServer可以将clientDetail存储在任何地方
        3. 根据clientId获取clientDetail
    7. 

