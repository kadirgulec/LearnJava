class HelloWorld{
    public static void main (String args[])
    {
        System.out.println("Hello World!!");
    }
}


public Integer[][] countVisitors(ComeLeave[] entry) {
    int count_entry = entry.length;
    int daysOfMonth = entry[0].getDate().getDaysOfMonth();
    Integer[][] visitors = new Integer[daysOfMonth][10];

    // Tablonun tamamini sifir ile doldur (Null degerinden kacinmak icin!)
    for (int i = 0; i < daysOfMonth; i++) {
        for (int j = 0; j < 10; j++) {
            visitors[i][j] = 0;
        }
    }

    for (int i = 0; i < count_entry; i++) {
        int day = entry[i].getDate().getDay();
        int hour = entry[i].getDate().getHour();
        int index_row = day - 1;
        int index_column = hour - 9;

        if (entry[i].getComeInOut() == 0) { // Giris
            for (int j = index_column; j < 10; j++) {
                visitors[index_row][j] += entry[i].getNoPeople();
            }
        } else { // Cikis
            for (int j = index_column + 1; j < 10; j++) {
                visitors[index_row][j] -= 1;
            }
        }
    }
    return visitors;
}
