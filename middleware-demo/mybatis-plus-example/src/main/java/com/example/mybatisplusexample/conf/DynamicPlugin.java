package com.example.mybatisplusexample.conf;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.util.ReflectionUtils;

import java.sql.Connection;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class DynamicPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {


        Connection conn = (Connection)invocation.getArgs()[0];
        //如果是采用了我们代理,则路由数据源
        if(conn instanceof ConnectionProxy){
            StatementHandler statementHandler = (StatementHandler) invocation
                    .getTarget();

            MappedStatement mappedStatement = null;
            if (statementHandler instanceof RoutingStatementHandler) {

                StatementHandler delegate = (StatementHandler) LocalReflectionUtils
                        .getFieldValue(statementHandler, "delegate");
                mappedStatement = (MappedStatement) LocalReflectionUtils.getFieldValue(
                        delegate, "mappedStatement");
            } else {
                mappedStatement = (MappedStatement) LocalReflectionUtils.getFieldValue(
                        statementHandler, "mappedStatement");
            }
            String key = AbstractDynamicDataSourceProxy.WRITE;

            if(mappedStatement.getSqlCommandType() == SqlCommandType.SELECT){
                key = AbstractDynamicDataSourceProxy.READ;
            }else{
                key = AbstractDynamicDataSourceProxy.WRITE;
            }

            ConnectionProxy connectionProxy = (ConnectionProxy)conn;
            connectionProxy.getTargetConnection(key);

        }

        return invocation.proceed();
    }
}
