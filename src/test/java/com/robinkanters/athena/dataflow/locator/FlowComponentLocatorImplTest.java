package com.robinkanters.athena.dataflow.locator;

import com.robinkanters.athena.dataflow.component.FlowComponent;
import com.robinkanters.athena.util.dummy.DummyFlowComponent;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.lang.Math.min;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlowComponentLocatorImplTest {
    private FlowComponentLocatorImpl componentLocator;

    private void assertEmpty(List all) {
        assertTrue(all.isEmpty());
    }

    @SafeVarargs
    private final void assertListEquals(List<Supplier<? extends FlowComponent>> all, Supplier<? extends FlowComponent>... components) {
        assertEquals(components.length, all.size());
        for (int i = 0; i < components.length; i++)
            assertEquals(components[i], all.get(i));
    }

    private Supplier<? extends FlowComponent>[] addNComponents(int amount) throws Exception {
        @SuppressWarnings("unchecked")
        Supplier<? extends FlowComponent>[] components = new Supplier[amount];

        for (int i = 0; i < min(amount, supplierWarehouse.size()); i++) {
            Supplier<? extends FlowComponent> component = supplierWarehouse.get(i);
            components[i] = component;
            componentLocator.add(component);
        }

        return components;
    }

    @Before
    public void setUp() throws Exception {
        componentLocator = new FlowComponentLocatorImpl();
    }

    @Test
    public void beforeAdd_AllReturnsEmptyList() throws Exception {
        assertEmpty(componentLocator.all());
    }

    @Test
    public void canaddComponent() throws Exception {
        componentLocator.add(DummyFlowComponent::new);
    }

    @Test
    public void afterAddThreeComponents_AllReturnsAllThree() throws Exception {
        Supplier<? extends FlowComponent>[] components = addNComponents(3);

        assertListEquals(componentLocator.all(), components);
    }

    @Test
    public void afterAddingTheSameComponentTwice_OnlyContainsOneInstance() throws Exception {
        Supplier<DummyFlowComponent> component = DummyFlowComponent::new;

        componentLocator.add(component);
        componentLocator.add(component);

        assertListEquals(componentLocator.all(), component);
    }

    @Test
    public void afteraddComponent_AllReturnsOnlyThatComponent() throws Exception {
        Supplier<DummyFlowComponent> component = DummyFlowComponent::new;
        componentLocator.add(component);

        List<Supplier<? extends FlowComponent>> all = componentLocator.all();

        assertListEquals(all, component);
    }

    @Test
    public void filterWithoutSpecifyingFilters_ReturnsAll() throws Exception {
        Supplier<? extends FlowComponent>[] components = addNComponents(3);

        List<Supplier<? extends FlowComponent>> filteredComponents = componentLocator.filter();

        assertListEquals(filteredComponents, components);
    }

    @Test
    public void canFilter() throws Exception {
        @SuppressWarnings("unchecked")
        Supplier<? extends FlowComponent>[] components = addNComponents(3);

        @SuppressWarnings("unchecked")
        Supplier<? extends FlowComponent>[] expectedComponents = new Supplier[]{components[0], components[2]};
        FlowComponent filteredComponent = components[1].get();

        List<Supplier<? extends FlowComponent>> filteredComponents =
                componentLocator.filter(supplier -> supplier.get().getClass() != filteredComponent.getClass());

        assertListEquals(filteredComponents, expectedComponents);
    }

    static final List<Supplier<? extends FlowComponent>> supplierWarehouse = new ArrayList<>();

    static {
        supplierWarehouse.add(DummyFlowComponent1::new);
        supplierWarehouse.add(DummyFlowComponent2::new);
        supplierWarehouse.add(DummyFlowComponent3::new);
        supplierWarehouse.add(DummyFlowComponent4::new);
        supplierWarehouse.add(DummyFlowComponent5::new);
    }

    static class DummyFlowComponent1 extends DummyFlowComponent {}
    static class DummyFlowComponent2 extends DummyFlowComponent {}
    static class DummyFlowComponent3 extends DummyFlowComponent {}
    static class DummyFlowComponent4 extends DummyFlowComponent {}
    static class DummyFlowComponent5 extends DummyFlowComponent {}
}