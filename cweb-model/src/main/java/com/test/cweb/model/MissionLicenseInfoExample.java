package com.test.cweb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hyl
 * @date 2018/02/25
 */
public class MissionLicenseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MissionLicenseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPkIdIsNull() {
            addCriterion("PK_ID is null");
            return (Criteria) this;
        }

        public Criteria andPkIdIsNotNull() {
            addCriterion("PK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPkIdEqualTo(Integer value) {
            addCriterion("PK_ID =", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotEqualTo(Integer value) {
            addCriterion("PK_ID <>", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdGreaterThan(Integer value) {
            addCriterion("PK_ID >", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PK_ID >=", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdLessThan(Integer value) {
            addCriterion("PK_ID <", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdLessThanOrEqualTo(Integer value) {
            addCriterion("PK_ID <=", value, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdIn(List<Integer> values) {
            addCriterion("PK_ID in", values, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotIn(List<Integer> values) {
            addCriterion("PK_ID not in", values, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdBetween(Integer value1, Integer value2) {
            addCriterion("PK_ID between", value1, value2, "pkId");
            return (Criteria) this;
        }

        public Criteria andPkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PK_ID not between", value1, value2, "pkId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMissionIdIsNull() {
            addCriterion("MISSION__ID is null");
            return (Criteria) this;
        }

        public Criteria andMissionIdIsNotNull() {
            addCriterion("MISSION__ID is not null");
            return (Criteria) this;
        }

        public Criteria andMissionIdEqualTo(Integer value) {
            addCriterion("MISSION__ID =", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdNotEqualTo(Integer value) {
            addCriterion("MISSION__ID <>", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdGreaterThan(Integer value) {
            addCriterion("MISSION__ID >", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MISSION__ID >=", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdLessThan(Integer value) {
            addCriterion("MISSION__ID <", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdLessThanOrEqualTo(Integer value) {
            addCriterion("MISSION__ID <=", value, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdIn(List<Integer> values) {
            addCriterion("MISSION__ID in", values, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdNotIn(List<Integer> values) {
            addCriterion("MISSION__ID not in", values, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdBetween(Integer value1, Integer value2) {
            addCriterion("MISSION__ID between", value1, value2, "missionId");
            return (Criteria) this;
        }

        public Criteria andMissionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MISSION__ID not between", value1, value2, "missionId");
            return (Criteria) this;
        }

        public Criteria andSignInStatusIsNull() {
            addCriterion("SIGN_IN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andSignInStatusIsNotNull() {
            addCriterion("SIGN_IN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSignInStatusEqualTo(Integer value) {
            addCriterion("SIGN_IN_STATUS =", value, "signInStatus");
            return (Criteria) this;
        }

        public Criteria andSignInStatusNotEqualTo(Integer value) {
            addCriterion("SIGN_IN_STATUS <>", value, "signInStatus");
            return (Criteria) this;
        }

        public Criteria andSignInStatusGreaterThan(Integer value) {
            addCriterion("SIGN_IN_STATUS >", value, "signInStatus");
            return (Criteria) this;
        }

        public Criteria andSignInStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("SIGN_IN_STATUS >=", value, "signInStatus");
            return (Criteria) this;
        }

        public Criteria andSignInStatusLessThan(Integer value) {
            addCriterion("SIGN_IN_STATUS <", value, "signInStatus");
            return (Criteria) this;
        }

        public Criteria andSignInStatusLessThanOrEqualTo(Integer value) {
            addCriterion("SIGN_IN_STATUS <=", value, "signInStatus");
            return (Criteria) this;
        }

        public Criteria andSignInStatusIn(List<Integer> values) {
            addCriterion("SIGN_IN_STATUS in", values, "signInStatus");
            return (Criteria) this;
        }

        public Criteria andSignInStatusNotIn(List<Integer> values) {
            addCriterion("SIGN_IN_STATUS not in", values, "signInStatus");
            return (Criteria) this;
        }

        public Criteria andSignInStatusBetween(Integer value1, Integer value2) {
            addCriterion("SIGN_IN_STATUS between", value1, value2, "signInStatus");
            return (Criteria) this;
        }

        public Criteria andSignInStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("SIGN_IN_STATUS not between", value1, value2, "signInStatus");
            return (Criteria) this;
        }

        public Criteria andSignInTimeIsNull() {
            addCriterion("SIGN_IN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSignInTimeIsNotNull() {
            addCriterion("SIGN_IN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSignInTimeEqualTo(Date value) {
            addCriterion("SIGN_IN_TIME =", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeNotEqualTo(Date value) {
            addCriterion("SIGN_IN_TIME <>", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeGreaterThan(Date value) {
            addCriterion("SIGN_IN_TIME >", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SIGN_IN_TIME >=", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeLessThan(Date value) {
            addCriterion("SIGN_IN_TIME <", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeLessThanOrEqualTo(Date value) {
            addCriterion("SIGN_IN_TIME <=", value, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeIn(List<Date> values) {
            addCriterion("SIGN_IN_TIME in", values, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeNotIn(List<Date> values) {
            addCriterion("SIGN_IN_TIME not in", values, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeBetween(Date value1, Date value2) {
            addCriterion("SIGN_IN_TIME between", value1, value2, "signInTime");
            return (Criteria) this;
        }

        public Criteria andSignInTimeNotBetween(Date value1, Date value2) {
            addCriterion("SIGN_IN_TIME not between", value1, value2, "signInTime");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusIsNull() {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusIsNotNull() {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusEqualTo(Integer value) {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS =", value, "firstScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusNotEqualTo(Integer value) {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS <>", value, "firstScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusGreaterThan(Integer value) {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS >", value, "firstScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS >=", value, "firstScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusLessThan(Integer value) {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS <", value, "firstScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusLessThanOrEqualTo(Integer value) {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS <=", value, "firstScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusIn(List<Integer> values) {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS in", values, "firstScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusNotIn(List<Integer> values) {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS not in", values, "firstScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusBetween(Integer value1, Integer value2) {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS between", value1, value2, "firstScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFirstScreenUploadStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("FIRST_SCREEN_UPLOAD_STATUS not between", value1, value2, "firstScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusIsNull() {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusIsNotNull() {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusEqualTo(Integer value) {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS =", value, "finalScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusNotEqualTo(Integer value) {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS <>", value, "finalScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusGreaterThan(Integer value) {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS >", value, "finalScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS >=", value, "finalScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusLessThan(Integer value) {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS <", value, "finalScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusLessThanOrEqualTo(Integer value) {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS <=", value, "finalScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusIn(List<Integer> values) {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS in", values, "finalScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusNotIn(List<Integer> values) {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS not in", values, "finalScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusBetween(Integer value1, Integer value2) {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS between", value1, value2, "finalScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andFinalScreenUploadStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("FINAL_SCREEN_UPLOAD_STATUS not between", value1, value2, "finalScreenUploadStatus");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusIsNull() {
            addCriterion("VIDEO_UPLOAD_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusIsNotNull() {
            addCriterion("VIDEO_UPLOAD_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusEqualTo(Integer value) {
            addCriterion("VIDEO_UPLOAD_STATUS =", value, "videoUploadStatus");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusNotEqualTo(Integer value) {
            addCriterion("VIDEO_UPLOAD_STATUS <>", value, "videoUploadStatus");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusGreaterThan(Integer value) {
            addCriterion("VIDEO_UPLOAD_STATUS >", value, "videoUploadStatus");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("VIDEO_UPLOAD_STATUS >=", value, "videoUploadStatus");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusLessThan(Integer value) {
            addCriterion("VIDEO_UPLOAD_STATUS <", value, "videoUploadStatus");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusLessThanOrEqualTo(Integer value) {
            addCriterion("VIDEO_UPLOAD_STATUS <=", value, "videoUploadStatus");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusIn(List<Integer> values) {
            addCriterion("VIDEO_UPLOAD_STATUS in", values, "videoUploadStatus");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusNotIn(List<Integer> values) {
            addCriterion("VIDEO_UPLOAD_STATUS not in", values, "videoUploadStatus");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusBetween(Integer value1, Integer value2) {
            addCriterion("VIDEO_UPLOAD_STATUS between", value1, value2, "videoUploadStatus");
            return (Criteria) this;
        }

        public Criteria andVideoUploadStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("VIDEO_UPLOAD_STATUS not between", value1, value2, "videoUploadStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}