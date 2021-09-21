# Order Spring Server
1. Gib alle Produkte aus
2. Bestelle ein/mehrere Produkt/e
3. Gib alle Bestellungen aus
4. **Bonus**: Ermögliche nach Produktnamen zu suchen



## URLs
(e.g. to enter in Postman)
- [GET] localhost:8080/products
- [GET] localhost:8080/products?search=t-shirt
- [GET] localhost:8080/orders
- [PUT] localhost:8080/orders
  
  - Body --> raw --> JSON auswählen
  - Listen von productIds eingeben, z.B. ``[1, 1, 4]``