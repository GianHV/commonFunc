public static void main(String[] args) {

        List<Predicate<Order>> conditions = new ArrayList<>();

        // where
        if (1 == 1) conditions.add(Order::isVendor);
        if (1 == 1) conditions.add(u -> u.getVendor().equals("Apple"));
        if (1 == 1) conditions.add(u -> u.getQuantity() > 3);

        Predicate<Order> combinedPredicate = conditions.stream()
                .reduce(n -> true, Predicate::and);

        // sort
        List<String> supplierOrder = Arrays.asList("Apple", "SamSung", "Google");
        Function<String, Integer> supplierPriority = supplierOrder::indexOf;

        List<Comparator<Order>> comparators = Arrays.asList(
                Comparator.comparing((Order o) -> supplierPriority.apply(o.getVendor())),
//                Comparator.comparing(Order::getProductName),
                Comparator.comparingDouble(Order::getPrice).reversed(),
                Comparator.comparingInt(Order::getQuantity).reversed()
        );

        Comparator<Order> dynamicComparator = comparators
                .stream()
                .reduce(Comparator::thenComparing)
                .orElseThrow();

        MockUp.orderList().stream()
                .filter(combinedPredicate)
                .sorted(dynamicComparator)
                .forEach(System.out::println);


    }