class FoodRatings {
    private Map<String, Set<RatedFood>> ratedFoodByCuisine = new HashMap<>();
    private Map<String, String> cuisineByFood = new HashMap<>();
    private Map<String, RatedFood> ratedFoodByFood = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; ++i) {
            Set<RatedFood> existing = ratedFoodByCuisine.get(cuisines[i]);
            if (existing == null) {
                ratedFoodByCuisine.put(cuisines[i], new TreeSet<>(new Comparator<RatedFood>() {
                    @Override
                    public int compare(RatedFood o1, RatedFood o2) {
                        if (o1.getRating() != o2.getRating()) {
                            return o2.getRating() - o1.getRating();
                        }
                        return o1.getName().compareTo(o2.getName());
                    }
                }));
            }
            RatedFood ratedFood = new RatedFood(foods[i], ratings[i]);
            ratedFoodByCuisine.get(cuisines[i]).add(ratedFood);
            cuisineByFood.put(foods[i], cuisines[i]);
            ratedFoodByFood.put(foods[i], ratedFood);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = cuisineByFood.get(food);
        RatedFood oldRatedFood = ratedFoodByFood.get(food);
        ratedFoodByCuisine.get(cuisine).remove(oldRatedFood);
        RatedFood ratedFood = new RatedFood(food, newRating);
        ratedFoodByCuisine.get(cuisine).add(ratedFood);
        ratedFoodByFood.put(food, ratedFood);
    }
    
    public String highestRated(String cuisine) {
        return ratedFoodByCuisine.get(cuisine).iterator().next().getName();
    }

    static class RatedFood {
        private String name;
        private int rating;

        RatedFood(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        String getName() {
            return name;
        }

        int getRating() {
            return rating;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */