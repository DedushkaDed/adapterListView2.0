# adapterListView2.0
Оптимизированная версия.
###
1) создаю 2-ой индентичный проект, но в этот раз избегаю "findViewByID" (затратно + долго)
2) избегаю layoutInflater.inflate - Не использую как основу, для демонстрации моего listView. А использую его в том случае,
если (convertView - являющийся основой функции: override fun getView (...., convertView: View?, ....)
convertView == null -> тогда мы инициализируем inflate.
3) Вместо моей переменной mContext => использую viewGroup (override fun getView)

1. Оптимизацировал findViewById
2. Избегаю layout.inflate
3. Вместо переменной mContext, использую встроенную библиотеку котлин*
