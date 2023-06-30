This repo contains test cases demonstrating differences with association comparisons between Hibernate 5 and 6.

User and comment entities are used in the example, comment has a `@ManyToOne` association to a user.
Adding `@NotFound` annotation to the association causes Hibernate to generate SQL with join instead of simple id comparison, which breaks for updates and deletes.

Example for select:

* without `@NotFound` - `select ... from comments c1_0 where c1_0.user_id=?`
* with `@NotFound` (both `IGNORE` and `EXCEPTION`) - `select ... from comments c1_0 left join users u1_0 on u1_0.id=c1_0.user_id where u1_0.id=?`

However, for updates and deletes the join is excluded and invalid SQL is produced - `delete from comments where u1_0.id=?`.

Without `@NotFound` valid SQL is generated - `delete from comments where user_id=?`, same SQL is generated in Hibernate 5 regardless of `@NotFound` presence.
