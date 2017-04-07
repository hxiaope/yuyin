package com.yuyin.pojo;

import java.util.ArrayList;
import java.util.List;

public class PeriodicalMusicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PeriodicalMusicExample() {
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

        public Criteria andPeriodicalIdIsNull() {
            addCriterion("periodical_id is null");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdIsNotNull() {
            addCriterion("periodical_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdEqualTo(Long value) {
            addCriterion("periodical_id =", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdNotEqualTo(Long value) {
            addCriterion("periodical_id <>", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdGreaterThan(Long value) {
            addCriterion("periodical_id >", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdGreaterThanOrEqualTo(Long value) {
            addCriterion("periodical_id >=", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdLessThan(Long value) {
            addCriterion("periodical_id <", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdLessThanOrEqualTo(Long value) {
            addCriterion("periodical_id <=", value, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdIn(List<Long> values) {
            addCriterion("periodical_id in", values, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdNotIn(List<Long> values) {
            addCriterion("periodical_id not in", values, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdBetween(Long value1, Long value2) {
            addCriterion("periodical_id between", value1, value2, "periodicalId");
            return (Criteria) this;
        }

        public Criteria andPeriodicalIdNotBetween(Long value1, Long value2) {
            addCriterion("periodical_id not between", value1, value2, "periodicalId");
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

        public Criteria andMusicimageIsNull() {
            addCriterion("musicimage is null");
            return (Criteria) this;
        }

        public Criteria andMusicimageIsNotNull() {
            addCriterion("musicimage is not null");
            return (Criteria) this;
        }

        public Criteria andMusicimageEqualTo(String value) {
            addCriterion("musicimage =", value, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicimageNotEqualTo(String value) {
            addCriterion("musicimage <>", value, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicimageGreaterThan(String value) {
            addCriterion("musicimage >", value, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicimageGreaterThanOrEqualTo(String value) {
            addCriterion("musicimage >=", value, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicimageLessThan(String value) {
            addCriterion("musicimage <", value, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicimageLessThanOrEqualTo(String value) {
            addCriterion("musicimage <=", value, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicimageLike(String value) {
            addCriterion("musicimage like", value, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicimageNotLike(String value) {
            addCriterion("musicimage not like", value, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicimageIn(List<String> values) {
            addCriterion("musicimage in", values, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicimageNotIn(List<String> values) {
            addCriterion("musicimage not in", values, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicimageBetween(String value1, String value2) {
            addCriterion("musicimage between", value1, value2, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicimageNotBetween(String value1, String value2) {
            addCriterion("musicimage not between", value1, value2, "musicimage");
            return (Criteria) this;
        }

        public Criteria andMusicpathIsNull() {
            addCriterion("musicpath is null");
            return (Criteria) this;
        }

        public Criteria andMusicpathIsNotNull() {
            addCriterion("musicpath is not null");
            return (Criteria) this;
        }

        public Criteria andMusicpathEqualTo(String value) {
            addCriterion("musicpath =", value, "musicpath");
            return (Criteria) this;
        }

        public Criteria andMusicpathNotEqualTo(String value) {
            addCriterion("musicpath <>", value, "musicpath");
            return (Criteria) this;
        }

        public Criteria andMusicpathGreaterThan(String value) {
            addCriterion("musicpath >", value, "musicpath");
            return (Criteria) this;
        }

        public Criteria andMusicpathGreaterThanOrEqualTo(String value) {
            addCriterion("musicpath >=", value, "musicpath");
            return (Criteria) this;
        }

        public Criteria andMusicpathLessThan(String value) {
            addCriterion("musicpath <", value, "musicpath");
            return (Criteria) this;
        }

        public Criteria andMusicpathLessThanOrEqualTo(String value) {
            addCriterion("musicpath <=", value, "musicpath");
            return (Criteria) this;
        }

        public Criteria andMusicpathLike(String value) {
            addCriterion("musicpath like", value, "musicpath");
            return (Criteria) this;
        }

        public Criteria andMusicpathNotLike(String value) {
            addCriterion("musicpath not like", value, "musicpath");
            return (Criteria) this;
        }

        public Criteria andMusicpathIn(List<String> values) {
            addCriterion("musicpath in", values, "musicpath");
            return (Criteria) this;
        }

        public Criteria andMusicpathNotIn(List<String> values) {
            addCriterion("musicpath not in", values, "musicpath");
            return (Criteria) this;
        }

        public Criteria andMusicpathBetween(String value1, String value2) {
            addCriterion("musicpath between", value1, value2, "musicpath");
            return (Criteria) this;
        }

        public Criteria andMusicpathNotBetween(String value1, String value2) {
            addCriterion("musicpath not between", value1, value2, "musicpath");
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

        public Criteria andMusicnameIsNull() {
            addCriterion("musicname is null");
            return (Criteria) this;
        }

        public Criteria andMusicnameIsNotNull() {
            addCriterion("musicname is not null");
            return (Criteria) this;
        }

        public Criteria andMusicnameEqualTo(String value) {
            addCriterion("musicname =", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameNotEqualTo(String value) {
            addCriterion("musicname <>", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameGreaterThan(String value) {
            addCriterion("musicname >", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameGreaterThanOrEqualTo(String value) {
            addCriterion("musicname >=", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameLessThan(String value) {
            addCriterion("musicname <", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameLessThanOrEqualTo(String value) {
            addCriterion("musicname <=", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameLike(String value) {
            addCriterion("musicname like", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameNotLike(String value) {
            addCriterion("musicname not like", value, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameIn(List<String> values) {
            addCriterion("musicname in", values, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameNotIn(List<String> values) {
            addCriterion("musicname not in", values, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameBetween(String value1, String value2) {
            addCriterion("musicname between", value1, value2, "musicname");
            return (Criteria) this;
        }

        public Criteria andMusicnameNotBetween(String value1, String value2) {
            addCriterion("musicname not between", value1, value2, "musicname");
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