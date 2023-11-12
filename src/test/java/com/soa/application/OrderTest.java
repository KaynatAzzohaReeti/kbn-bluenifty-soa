package com.soa.application;

import com.soa.application.common.events.DomainEvent;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.NESTED_CLASSES;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.assignableTo;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideOutsideOfPackages;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

class CleanModulesArchTest {

    @Test
    void sales_catalog_service_has_no_dependency_on_others() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.sales.catalog");
        ArchRule rule = classes().should().onlyDependOnClassesThat(
                resideOutsideOfPackages(
                        "com.soa.application.."
                ).or(resideInAPackage("com.soa.application.sales.catalog.."
                ).or(resideInAPackage("com.soa.application.common.."))));
        rule.check(importedClasses);
    }

    @Test
    void sales_catalog_domain_has_no_dependency_to_its_implementation() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.sales.catalog");
        ArchRule rule = classes()
                .that().resideOutsideOfPackages(
                        "com.soa.application.sales.catalog.jdbc..")
                .should().onlyDependOnClassesThat().resideOutsideOfPackages(
                        "com.soa.application.sales.catalog.jdbc..");
        rule.check(importedClasses);
    }

    @Test
    void sales_order_service_has_no_dependencies_on_others_except_events() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.sales.order");
        ArchRule rule = classes().should().onlyDependOnClassesThat(
                resideOutsideOfPackages(
                        "com.soa.application.."
                ).or(resideInAPackage("com.soa.application.sales.order.."
                ).or(resideInAPackage("com.soa.application.common..")
                ).or(assignableTo(DomainEvent.class).or(NESTED_CLASSES))));
        rule.check(importedClasses);
    }

    @Test
    void sales_order_domain_has_no_dependency_to_its_implementation() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.sales.order");
        ArchRule rule = classes()
                .that().resideOutsideOfPackages(
                        "com.soa.application.sales.order.jdbc..")
                .should().onlyDependOnClassesThat().resideOutsideOfPackages(
                        "com.soa.application.sales.order.jdbc..");
        rule.check(importedClasses);
    }

    @Test
    void sales_cart_service_has_no_dependency_on_others() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.sales.cart");
        ArchRule rule = classes().should().onlyDependOnClassesThat(
                resideOutsideOfPackages(
                        "com.soa.application.."
                ).or(resideInAPackage("com.soa.application.sales.cart.."
                ).or(resideInAPackage("com.soa.application.common.."))));
        rule.check(importedClasses);
    }

    @Test
    void billing_payment_service_has_no_dependencies_on_others_except_events() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.billing.payment");
        ArchRule rule = classes().should().onlyDependOnClassesThat(
                resideOutsideOfPackages(
                        "com.soa.application.."
                ).or(resideInAPackage("com.soa.application.billing.payment.."
                ).or(resideInAPackage("com.soa.application.common..")
                ).or(assignableTo(DomainEvent.class).or(NESTED_CLASSES))));
        rule.check(importedClasses);
    }

    @Test
    void billing_payment_domain_has_no_dependency_to_its_implementation() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.billing.payment");
        ArchRule rule = classes()
                .that().resideOutsideOfPackages(
                        "com.soa.application.billing.payment.jdbc..")
                .should().onlyDependOnClassesThat().resideOutsideOfPackages(
                        "com.soa.application.billing.payment.jdbc..");
        rule.check(importedClasses);
    }

    @Test
    void shipping_delivery_service_has_no_dependencies_on_others_except_events() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.shipping.delivery");
        ArchRule rule = classes().should().onlyDependOnClassesThat(
                resideOutsideOfPackages(
                        "com.soa.application.."
                ).or(resideInAPackage("com.soa.application.shipping.delivery.."
                ).or(resideInAPackage("com.soa.application.common..")
                ).or(assignableTo(DomainEvent.class).or(NESTED_CLASSES))));
        rule.check(importedClasses);
    }

    @Test
    void shipping_delivery_domain_has_no_dependency_to_its_implementation() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.shipping.delivery");
        ArchRule rule = classes()
                .that().resideOutsideOfPackages(
                        "com.soa.application.shipping.delivery.jdbc..")
                .should().onlyDependOnClassesThat().resideOutsideOfPackages(
                        "com.soa.application.shipping.delivery.jdbc..");
        rule.check(importedClasses);
    }

    @Test
    void shipping_dispatching_service_has_no_dependencies_on_others_except_delivery_and_events() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.shipping.dispatching");
        ArchRule rule = classes().should().onlyDependOnClassesThat(
                resideOutsideOfPackages(
                        "com.soa.application.."
                ).or(resideInAPackage("com.soa.application.shipping.dispatching.."
                ).or(resideInAPackage("com.soa.application.shipping.delivery..")
                ).or(resideInAPackage("com.soa.application.common..")
                ).or(assignableTo(DomainEvent.class).or(NESTED_CLASSES))));
        rule.check(importedClasses);
    }

    @Test
    void shipping_dispatching_domain_has_no_dependency_to_its_implementation() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.shipping.dispatching");
        ArchRule rule = classes()
                .that().resideOutsideOfPackages(
                        "com.soa.application.shipping.dispatching.jdbc..")
                .should().onlyDependOnClassesThat().resideOutsideOfPackages(
                        "com.soa.application.shipping.dispatching.jdbc..");
        rule.check(importedClasses);
    }

    @Test
    void warehouse_service_has_no_dependencies_on_others_except_events() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.warehouse");
        ArchRule rule = classes().should().onlyDependOnClassesThat(
                resideOutsideOfPackages(
                        "com.soa.application.."
                ).or(resideInAPackage("com.soa.application.warehouse.."
                ).or(resideInAPackage("com.soa.application.common..")
                ).or(assignableTo(DomainEvent.class).or(NESTED_CLASSES))));
        rule.check(importedClasses);
    }

    @Test
    void warehouse_domain_has_no_dependency_to_its_implementation() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.warehouse");
        ArchRule rule = classes()
                .that().resideOutsideOfPackages(
                        "com.soa.application.warehouse.jdbc..")
                .should().onlyDependOnClassesThat().resideOutsideOfPackages(
                        "com.soa.application.warehouse.jdbc..");
        rule.check(importedClasses);
    }

    @Test
    void catalog_service_has_no_dependencies_on_billing() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.soa.application.portal");
        ArchRule rule = classes()
                .should().onlyDependOnClassesThat().resideOutsideOfPackages(
                        "com.soa.application.billing..");
        rule.check(importedClasses);
    }

    @Test
    void portal_web_uses_only_its_own_use_cases_and_no_direct_dependencies_on_other_services() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(
                "com.soa.application.sales",
                "com.soa.application.warehouse",
                "com.soa.application.shipping",
                "com.soa.application.billing");
        ArchRule rule = classes()
                .should().onlyHaveDependentClassesThat().resideOutsideOfPackage(
                        "com.soa.application.portal.web..");
        rule.check(importedClasses);
    }
}
