package com.fly.wechat.mpdemo.match.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameExample() {
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

        public Criteria andMatchIdIsNull() {
            addCriterion("match_id is null");
            return (Criteria) this;
        }

        public Criteria andMatchIdIsNotNull() {
            addCriterion("match_id is not null");
            return (Criteria) this;
        }

        public Criteria andMatchIdEqualTo(String value) {
            addCriterion("match_id =", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotEqualTo(String value) {
            addCriterion("match_id <>", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdGreaterThan(String value) {
            addCriterion("match_id >", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdGreaterThanOrEqualTo(String value) {
            addCriterion("match_id >=", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLessThan(String value) {
            addCriterion("match_id <", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLessThanOrEqualTo(String value) {
            addCriterion("match_id <=", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdLike(String value) {
            addCriterion("match_id like", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotLike(String value) {
            addCriterion("match_id not like", value, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdIn(List<String> values) {
            addCriterion("match_id in", values, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotIn(List<String> values) {
            addCriterion("match_id not in", values, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdBetween(String value1, String value2) {
            addCriterion("match_id between", value1, value2, "matchId");
            return (Criteria) this;
        }

        public Criteria andMatchIdNotBetween(String value1, String value2) {
            addCriterion("match_id not between", value1, value2, "matchId");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNull() {
            addCriterion("game_id is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("game_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(String value) {
            addCriterion("game_id =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(String value) {
            addCriterion("game_id <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(String value) {
            addCriterion("game_id >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(String value) {
            addCriterion("game_id >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(String value) {
            addCriterion("game_id <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(String value) {
            addCriterion("game_id <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLike(String value) {
            addCriterion("game_id like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotLike(String value) {
            addCriterion("game_id not like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<String> values) {
            addCriterion("game_id in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<String> values) {
            addCriterion("game_id not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(String value1, String value2) {
            addCriterion("game_id between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(String value1, String value2) {
            addCriterion("game_id not between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(String value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(String value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(String value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(String value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(String value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(String value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLike(String value) {
            addCriterion("aid like", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotLike(String value) {
            addCriterion("aid not like", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<String> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<String> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(String value1, String value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(String value1, String value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(String value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(String value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(String value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(String value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(String value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(String value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLike(String value) {
            addCriterion("bid like", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotLike(String value) {
            addCriterion("bid not like", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<String> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<String> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(String value1, String value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(String value1, String value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andAscoreIsNull() {
            addCriterion("ascore is null");
            return (Criteria) this;
        }

        public Criteria andAscoreIsNotNull() {
            addCriterion("ascore is not null");
            return (Criteria) this;
        }

        public Criteria andAscoreEqualTo(Integer value) {
            addCriterion("ascore =", value, "ascore");
            return (Criteria) this;
        }

        public Criteria andAscoreNotEqualTo(Integer value) {
            addCriterion("ascore <>", value, "ascore");
            return (Criteria) this;
        }

        public Criteria andAscoreGreaterThan(Integer value) {
            addCriterion("ascore >", value, "ascore");
            return (Criteria) this;
        }

        public Criteria andAscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("ascore >=", value, "ascore");
            return (Criteria) this;
        }

        public Criteria andAscoreLessThan(Integer value) {
            addCriterion("ascore <", value, "ascore");
            return (Criteria) this;
        }

        public Criteria andAscoreLessThanOrEqualTo(Integer value) {
            addCriterion("ascore <=", value, "ascore");
            return (Criteria) this;
        }

        public Criteria andAscoreIn(List<Integer> values) {
            addCriterion("ascore in", values, "ascore");
            return (Criteria) this;
        }

        public Criteria andAscoreNotIn(List<Integer> values) {
            addCriterion("ascore not in", values, "ascore");
            return (Criteria) this;
        }

        public Criteria andAscoreBetween(Integer value1, Integer value2) {
            addCriterion("ascore between", value1, value2, "ascore");
            return (Criteria) this;
        }

        public Criteria andAscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("ascore not between", value1, value2, "ascore");
            return (Criteria) this;
        }

        public Criteria andBscoreIsNull() {
            addCriterion("bscore is null");
            return (Criteria) this;
        }

        public Criteria andBscoreIsNotNull() {
            addCriterion("bscore is not null");
            return (Criteria) this;
        }

        public Criteria andBscoreEqualTo(Integer value) {
            addCriterion("bscore =", value, "bscore");
            return (Criteria) this;
        }

        public Criteria andBscoreNotEqualTo(Integer value) {
            addCriterion("bscore <>", value, "bscore");
            return (Criteria) this;
        }

        public Criteria andBscoreGreaterThan(Integer value) {
            addCriterion("bscore >", value, "bscore");
            return (Criteria) this;
        }

        public Criteria andBscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("bscore >=", value, "bscore");
            return (Criteria) this;
        }

        public Criteria andBscoreLessThan(Integer value) {
            addCriterion("bscore <", value, "bscore");
            return (Criteria) this;
        }

        public Criteria andBscoreLessThanOrEqualTo(Integer value) {
            addCriterion("bscore <=", value, "bscore");
            return (Criteria) this;
        }

        public Criteria andBscoreIn(List<Integer> values) {
            addCriterion("bscore in", values, "bscore");
            return (Criteria) this;
        }

        public Criteria andBscoreNotIn(List<Integer> values) {
            addCriterion("bscore not in", values, "bscore");
            return (Criteria) this;
        }

        public Criteria andBscoreBetween(Integer value1, Integer value2) {
            addCriterion("bscore between", value1, value2, "bscore");
            return (Criteria) this;
        }

        public Criteria andBscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("bscore not between", value1, value2, "bscore");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailIsNull() {
            addCriterion("ascore_detail is null");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailIsNotNull() {
            addCriterion("ascore_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailEqualTo(String value) {
            addCriterion("ascore_detail =", value, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailNotEqualTo(String value) {
            addCriterion("ascore_detail <>", value, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailGreaterThan(String value) {
            addCriterion("ascore_detail >", value, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailGreaterThanOrEqualTo(String value) {
            addCriterion("ascore_detail >=", value, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailLessThan(String value) {
            addCriterion("ascore_detail <", value, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailLessThanOrEqualTo(String value) {
            addCriterion("ascore_detail <=", value, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailLike(String value) {
            addCriterion("ascore_detail like", value, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailNotLike(String value) {
            addCriterion("ascore_detail not like", value, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailIn(List<String> values) {
            addCriterion("ascore_detail in", values, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailNotIn(List<String> values) {
            addCriterion("ascore_detail not in", values, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailBetween(String value1, String value2) {
            addCriterion("ascore_detail between", value1, value2, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andAscoreDetailNotBetween(String value1, String value2) {
            addCriterion("ascore_detail not between", value1, value2, "ascoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailIsNull() {
            addCriterion("bscore_detail is null");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailIsNotNull() {
            addCriterion("bscore_detail is not null");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailEqualTo(String value) {
            addCriterion("bscore_detail =", value, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailNotEqualTo(String value) {
            addCriterion("bscore_detail <>", value, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailGreaterThan(String value) {
            addCriterion("bscore_detail >", value, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailGreaterThanOrEqualTo(String value) {
            addCriterion("bscore_detail >=", value, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailLessThan(String value) {
            addCriterion("bscore_detail <", value, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailLessThanOrEqualTo(String value) {
            addCriterion("bscore_detail <=", value, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailLike(String value) {
            addCriterion("bscore_detail like", value, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailNotLike(String value) {
            addCriterion("bscore_detail not like", value, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailIn(List<String> values) {
            addCriterion("bscore_detail in", values, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailNotIn(List<String> values) {
            addCriterion("bscore_detail not in", values, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailBetween(String value1, String value2) {
            addCriterion("bscore_detail between", value1, value2, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andBscoreDetailNotBetween(String value1, String value2) {
            addCriterion("bscore_detail not between", value1, value2, "bscoreDetail");
            return (Criteria) this;
        }

        public Criteria andGameDidianIsNull() {
            addCriterion("game_didian is null");
            return (Criteria) this;
        }

        public Criteria andGameDidianIsNotNull() {
            addCriterion("game_didian is not null");
            return (Criteria) this;
        }

        public Criteria andGameDidianEqualTo(String value) {
            addCriterion("game_didian =", value, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameDidianNotEqualTo(String value) {
            addCriterion("game_didian <>", value, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameDidianGreaterThan(String value) {
            addCriterion("game_didian >", value, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameDidianGreaterThanOrEqualTo(String value) {
            addCriterion("game_didian >=", value, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameDidianLessThan(String value) {
            addCriterion("game_didian <", value, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameDidianLessThanOrEqualTo(String value) {
            addCriterion("game_didian <=", value, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameDidianLike(String value) {
            addCriterion("game_didian like", value, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameDidianNotLike(String value) {
            addCriterion("game_didian not like", value, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameDidianIn(List<String> values) {
            addCriterion("game_didian in", values, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameDidianNotIn(List<String> values) {
            addCriterion("game_didian not in", values, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameDidianBetween(String value1, String value2) {
            addCriterion("game_didian between", value1, value2, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameDidianNotBetween(String value1, String value2) {
            addCriterion("game_didian not between", value1, value2, "gameDidian");
            return (Criteria) this;
        }

        public Criteria andGameTimeIsNull() {
            addCriterion("game_time is null");
            return (Criteria) this;
        }

        public Criteria andGameTimeIsNotNull() {
            addCriterion("game_time is not null");
            return (Criteria) this;
        }

        public Criteria andGameTimeEqualTo(Date value) {
            addCriterion("game_time =", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeNotEqualTo(Date value) {
            addCriterion("game_time <>", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeGreaterThan(Date value) {
            addCriterion("game_time >", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("game_time >=", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeLessThan(Date value) {
            addCriterion("game_time <", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeLessThanOrEqualTo(Date value) {
            addCriterion("game_time <=", value, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeIn(List<Date> values) {
            addCriterion("game_time in", values, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeNotIn(List<Date> values) {
            addCriterion("game_time not in", values, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeBetween(Date value1, Date value2) {
            addCriterion("game_time between", value1, value2, "gameTime");
            return (Criteria) this;
        }

        public Criteria andGameTimeNotBetween(Date value1, Date value2) {
            addCriterion("game_time not between", value1, value2, "gameTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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