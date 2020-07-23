package com.soft.shares.entity;

public class StockInfoRequestDTO {

    /**
     * 文件名称
     */
    private String file;

    /**
     * 公司类型
     */
    private String companyType;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
}
