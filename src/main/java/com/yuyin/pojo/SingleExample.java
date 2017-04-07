package com.yuyin.pojo;

import java.util.ArrayList;
import java.util.List;

public class SingleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SingleExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMusicIdIsNull() {
            addCriterion("music_id is null");
            return (Criteria) this;
        }

        public Criteria andMusicIdIsNotNull() {
            addCriterion("music_id is not null");
            return (Criteria) this;
        }

        public Criteria andMusicIdEqualTo(Long value) {
            addCriterion("music_id =", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotEqualTo(Long value) {
            addCriterion("music_id <>", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdGreaterThan(Long value) {
            addCriterion("music_id >", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdGreaterThanOrEqualTo(Long value) {
            addCriterion("music_id >=", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdLessThan(Long value) {
            addCriterion("music_id <", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdLessThanOrEqualTo(Long value) {
            addCriterion("music_id <=", value, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdIn(List<Long> values) {
            addCriterion("music_id in", values, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotIn(List<Long> values) {
            addCriterion("music_id not in", values, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdBetween(Long value1, Long value2) {
            addCriterion("music_id between", value1, value2, "musicId");
            return (Criteria) this;
        }

        public Criteria andMusicIdNotBetween(Long value1, Long value2) {
            addCriterion("music_id not between", value1, value2, "musicId");
            return (Criteria) this;
        }

        public Criteria andSingleauthorIsNull() {
            addCriterion("singleauthor is null");
            return (Criteria) this;
        }

        public Criteria andSingleauthorIsNotNull() {
            addCriterion("singleauthor is not null");
            return (Criteria) this;
        }

        public Criteria andSingleauthorEqualTo(String value) {
            addCriterion("singleauthor =", value, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andSingleauthorNotEqualTo(String value) {
            addCriterion("singleauthor <>", value, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andSingleauthorGreaterThan(String value) {
            addCriterion("singleauthor >", value, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andSingleauthorGreaterThanOrEqualTo(String value) {
            addCriterion("singleauthor >=", value, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andSingleauthorLessThan(String value) {
            addCriterion("singleauthor <", value, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andSingleauthorLessThanOrEqualTo(String value) {
            addCriterion("singleauthor <=", value, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andSingleauthorLike(String value) {
            addCriterion("singleauthor like", value, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andSingleauthorNotLike(String value) {
            addCriterion("singleauthor not like", value, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andSingleauthorIn(List<String> values) {
            addCriterion("singleauthor in", values, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andSingleauthorNotIn(List<String> values) {
            addCriterion("singleauthor not in", values, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andSingleauthorBetween(String value1, String value2) {
            addCriterion("singleauthor between", value1, value2, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andSingleauthorNotBetween(String value1, String value2) {
            addCriterion("singleauthor not between", value1, value2, "singleauthor");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createtime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createtime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andSingleimageIsNull() {
            addCriterion("singleimage is null");
            return (Criteria) this;
        }

        public Criteria andSingleimageIsNotNull() {
            addCriterion("singleimage is not null");
            return (Criteria) this;
        }

        public Criteria andSingleimageEqualTo(String value) {
            addCriterion("singleimage =", value, "singleimage");
            return (Criteria) this;
        }

        public Criteria andSingleimageNotEqualTo(String value) {
            addCriterion("singleimage <>", value, "singleimage");
            return (Criteria) this;
        }

        public Criteria andSingleimageGreaterThan(String value) {
            addCriterion("singleimage >", value, "singleimage");
            return (Criteria) this;
        }

        public Criteria andSingleimageGreaterThanOrEqualTo(String value) {
            addCriterion("singleimage >=", value, "singleimage");
            return (Criteria) this;
        }

        public Criteria andSingleimageLessThan(String value) {
            addCriterion("singleimage <", value, "singleimage");
            return (Criteria) this;
        }

        public Criteria andSingleimageLessThanOrEqualTo(String value) {
            addCriterion("singleimage <=", value, "singleimage");
            return (Criteria) this;
        }

        public Criteria andSingleimageLike(String value) {
            addCriterion("singleimage like", value, "singleimage");
            return (Criteria) this;
        }

        public Criteria andSingleimageNotLike(String value) {
            addCriterion("singleimage not like", value, "singleimage");
            return (Criteria) this;
        }

        public Criteria andSingleimageIn(List<String> values) {
            addCriterion("singleimage in", values, "singleimage");
            return (Criteria) this;
        }

        public Criteria andSingleimageNotIn(List<String> values) {
            addCriterion("singleimage not in", values, "singleimage");
            return (Criteria) this;
        }

        public Criteria andSingleimageBetween(String value1, String value2) {
            addCriterion("singleimage between", value1, value2, "singleimage");
            return (Criteria) this;
        }

        public Criteria andSingleimageNotBetween(String value1, String value2) {
            addCriterion("singleimage not between", value1, value2, "singleimage");
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