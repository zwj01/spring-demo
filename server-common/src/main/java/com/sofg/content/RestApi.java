package com.sofg.content;

public class RestApi {
    public static class RequestKey {

        public final static String H_TOKEN = "H_token";
        public final static String H_API_KEY = "H_api_key";
        public final static String H_SIGN = "H_sign";
        public final static String H_TIMESTAMP = "H_timestamp";
        public final static String H_CLIENT_IP = "H_client_ip";
        public final static String H_REQUEST_ID = "H_request_id";//请求ID
        public final static String H_REQUEST_TIME = "H_request_time";//请求ID
        public final static String USER_PUBLIC_KEY = "H_user_public_key"; // 用户公钥KEY值
        public final static String SERVER_PUBLIC_KEY = "H_server_public_key"; // 服务器公钥KEY值
        public final static String H_TOKEN_EXPIRE_TIME = "tokenExpireTime";
        public final static String H_SERVER_PUBLIC_KEY_EXPIRE_TIME = "serverPublicKeyExpireTime";
        public final static String MSG = "msg";
        public final static String CODE = "code";
        public final static String DATA = "data";
        public final static String MENU_ID = "menu_id"; // 菜单ID

        public final static String HEADERS_ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
    }

    public static class RequestValue {

        public final static String HEADERS_ACCESS_CONTROL_EXPOSE_HEADERS = "Authorization";

    }

    public static class Code {

        public final static int SUCCESS = 0;
        public final static int PARAMER_ERROR = 1;
        public final static int FAIL = -1;
        public final static int NOT_USER = 2;
        public final static int SHRIO_EXECUTE_LOGIN_ERROR = 3;
        public final static int RSA_VERIFY_FAIL = 4;
        public final static int RSA_CREATE_FAIL = 5;
        public final static int REDIS_SET_FAIL = 6;
        public final static int RESP_HEAD_CONFIG_FAIL = 7;
        public final static int CREATE_TOKEN_FAIL = 8;
        public final static int USER_PASSWORD_ERROR = 9;
        public final static int NOT_DATA = 10;
        public final static int NOT_DATA_AUTH = 11;

        //权限
        public final static int isuser = 22;
        public final static int isrequired = 23;
        public final static int IS_JSON_CONTENT_TYPE = 24;
        public final static int IS_JSONObject = 25;
        public final static int Eureka = 26;
        public final static int is_token = 27;
        public final static int is_not_usersession = 28;
        public final static int is_not_user = 9;
        public final static int is_not_passwd_old = 10;
        public final static int is_not_passwd = 11;
        public final static int is_passwd = 12;
        public final static int is_operator = 13;
        public final static int MENU_NAME_EXIST_CODE = 14;
        public final static int ORG_NAME_EXIST_CODE = 15;
        public final static int POST_NAME_EXIST_CODE = 16;
        public final static int PARENT_STATUS_NOT_USE = 17;

        //系统字典
        public final static int delte_false_foreign_key =1001;
        public final static int dictionary_type_add_key =1002;
        public final static int dictionary_type_edit_key =1003;

        public final static int dictionary_add_key =1004;
        public final static int dictionary_edit_key =1005;

        public final static int dictionary_inputdata_key =1006;

        public final static int PROJECT_TASK_EXIST_ERROR = 100;
    }

    public static class Msg {

        public final static String SUCCESS = "success";
        public final static String FAIL = "fail";
        public final static String PARAMER_ERROR = "paramer error";
        public final static String NOT_USER = "not user";
        public final static String RSA_VERIFY_FAIL = "RSA verify fail";
        public final static String RSA_CREATE_FAIL = "RSA key create fail";
        public final static String REDIS_SET_FAIL = "redis set fail";
        public final static String RESP_HEAD_CONFIG_FAIL = "response set header config fail";
        public final static String CREATE_TOKEN_FAIL = "create token fail";
        public final static String USER_PASSWORD_ERROR = "user password error";
        public final static String NOT_DATA = "not data";
        public final static String NOT_DATA_AUTH = "not data operator authority";
        public final static String USER_EXPIRED = "user expired";
        public final static String CONNECTION_FAIL = "connection fail";

        //权限
        public final static String isuser = "用户已存在";
        public final static String isrequired = "参数不可为空";
        public final static String IS_JSON_CONTENT_TYPE = "请求格式必须为：application/json：";
        public final static String IS_JSONObject = "json格式异常";
        public final static String Eureka = "Eureka异常";
        public final static String is_token = "token获取失败";
        public final static String is_not_usersession = "token获取用户id失败";
        public final static String is_not_user = "用户不存在";
        public final static String is_not_passwd_old = "新旧密码不能相同";
        public final static String is_not_passwd = "旧密码验证失败";
        public final static String is_passwd = "密码长度异常";
        public final static String is_operator = "功能权限编码已存在，请更换新的功能权限编码";
        public final static String MENU_NAME_EXIST_CODE = "菜单名称已存在";
        public final static String ORG_NAME_EXIST_CODE = "部门名称已存在";
        public final static String POST_NAME_EXIST_CODE = "岗位名称已存在";
        public final static String PARENT_STATUS_NOT_USE = "父级部门未启用";

        //系统字典
        public final static String delte_false_foreign_key ="请先删除字典";
        public final static String dictionary_type_add_key ="新增字典类型名称重复！";
        public final static String dictionary_type_edit_key ="编辑字典类型名称重复！";

        public final static String dictionary_add_key ="新增字典名称重复或字典key重复！！！！";
        public final static String dictionary_edit_key ="编辑字典名称重复或字典key重复！！！";

        public final static String dictionary_inputdata_key ="导入数据异常，请检查导入文件必填项！！！！";

        //项目模块
        public final static String PROJECT_TASK_EXIST_ERROR = "项目中存在任务";

        //同步任务模型
        public final static String CREATE_DATA_MANAGE = "创建数据模型";
        public final static String NOT_CREATE_DATA_MANAGE = "不创建数据模型";
        public final static String CREATED_SUCCESS = "创建成功";
        public final static String SUCCESS_FLAG = "0";
        public final static String CREATED_FAILED = "创建失败";
        public final static String FILED_FLAG = "-1";


    }
    //下面的代码会被废除
    public static class msgUtil {

        public final static int success = 0;
        public final static int faild = 1;
        public final static int isuser = 22;
        public final static int isrequired = 23;
        public final static int IS_JSON_CONTENT_TYPE = 24;
        public final static int IS_JSONObject = 25;
        public final static int Eureka = 26;
        public final static int is_token = 27;
        public final static int is_not_usersession = 28;
        public final static int is_not_user = 9;
        public final static int is_not_passwd_old = 10;
        public final static int is_not_passwd = 11;
        public final static int is_passwd = 12;
        public final static int is_operator = 13;
        public final static int MENU_NAME_EXIST_CODE = 14;
        public final static int ORG_NAME_EXIST_CODE = 15;
        public final static int POST_NAME_EXIST_CODE = 16;
        public final static int PARENT_STATUS_NOT_USE = 17;

        public static String getMsg(int value) {
            return strutsmsg.getmsg(value);
        }
    }



    public enum strutsmsg {
        success("成功", 0), faild("失敗", 1), isuser("用户已存在", 22), isrequired("参数不可为空", 23),
        IS_JSON_CONTENT_TYPE("请求格式必须为：application/json：", 24), IS_JSONObject("json格式异常", 25), Eureka("失敗", 26),
        is_token("token获取失败", 27), is_not_usersession("token获取用户id失败", 28), is_not_user("用户不存在", 9),
        is_not_passwd_old("新旧密码不能相同", 10), is_not_passwd("旧密码验证失败", 11), is_passwd("密码长度异常", 12),
        is_operator("功能权限编码已存在，请更换新的功能权限编码", 13), MENU_NAME_EXIST_CODE("菜单名称已存在", 14),
        ORG_NAME_EXIST_CODE("部门名称已存在", 15), POST_NAME_EXIST_CODE("岗位名称已存在", 16), PARENT_STATUS_NOT_USE("父级部门未启用", 17);

        private String msg;
        private int index;

        // 构造方法
        private strutsmsg(String msg, int index) {
            this.msg = msg;
            this.index = index;
        }

        // 普通方法
        public static String getmsg(int index) {
            for (strutsmsg c : strutsmsg.values()) {
                if (c.getIndex() == index) {
                    return c.msg;
                }
            }
            return null;
        }

        /**
         * @return the msg
         */
        public String getMsg() {
            return msg;
        }

        /**
         * @return the index
         */
        public int getIndex() {
            return index;
        }

    }
}
