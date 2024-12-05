package com.token.constant;

/**
 * 描述相关常量
 */
public interface MessageConstant {

    /**
     * 描述词
     */
    String USERNAME_NOT_EMPTY = "用户名不能为空";
    String USERNAME_LENGTH_RANGE = "用户名长度3~12";
    String PASSWORD_NOT_EMPTY = "密码不能为空";
    String PASSWORD_LENGTH_RANGE = "密码长度3~12";
    String ACCOUNT_NOT_EXIST = "账号不存在";
    String PASSWORD_ERROR = "密码错误";
    String ACCOUNT_IS_DISABLE = "账号已禁用";
    String NAME_NOT_EMPTY = "姓名不能为空";
    String NAME_LENGTH_RANGE = "姓名长度为2~12";
    String PHONE_NOT_EMPTY = "手机号不能为空";
    String PHONE_FORMAT_ERROR = "手机号格式错误";
    String PHONE_REGULAR = "手机号只能为11位";
    String SEX_FORMAT_ERROR = "性别格式错误";
    String USERNAME_IS_EXIST = "用户名已存在";
    String OPERATE_SUCCESS = "操作成功";
    String UPLOAD_FAILED = "上传失败";
    String CATEGORY_TYPE_ERROR = "分类类型错误";
    String CATEGORY_NAME_NOT_EMPTY = "分类名称不能为空";
    String CATEGORY_NOT_EXIST = "该分类不存在";
    String CATEGORY_EXIST = "该分类已存在";
    String CATEGORY_STATUS_IS_ENABLE = "有分类状态为启用";
    String GOODS_NAME_NOT_EMPTY = "商品名称不能为空";
    String CATEGORY_ID_NOT_EMPTY = "分类id不能为空";
    String GOODS_NAME_IS_EXIST = "商品名称已存在";
    String GOODS_STATUS_IS_ENABLE="商品状态为启用状态";
    String USER_NOT_LOGIN = "用户未登录";
    String TOKEN_ERROR = "TOKEN错误";
    String INSUFFICIENT_PERMISSIONS = "权限不足";
    String AUTHENTICATION_FAILED = "认证失败";
    String SETMEAL_NAME_NOT_EMPTY = "套餐名称不能为空";
    String EMPLOYEE_STATUS_IS_ENABLE = "有用户状态为启用";
    String SETMEAL_STATUS_IS_ENABLE="套餐售卖状态为起售";
}
