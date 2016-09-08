package com.robinkanters.athena.dataflow.locator;

import com.robinkanters.athena.dataflow.component.FlowComponent;
import com.robinkanters.athena.util.dummy.DummyFlowComponent;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlowComponentLocatorImplTest {
    private FlowComponentLocatorImpl componentLocator;

    private void assertEmpty(List all) {
        assertTrue(all.isEmpty());
    }

    private void assertListEquals(List<FlowComponent> all, FlowComponent... components) {
        assertEquals(components.length, all.size());
        for(int i=0; i<components.length; i++)
            assertEquals(components[i], all.get(i));
    }

    private FlowComponent[] addNComponents(int amount) {
        FlowComponent[] components = new FlowComponent[amount];
        for(int i=0; i<amount; i++) {
            FlowComponent component = new DummyFlowComponent();
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
    public void beforeadd_AllReturnsEmptyList() throws Exception {
        assertEmpty(componentLocator.all());
    }

    @Test
    public void canaddComponent() throws Exception {
        componentLocator.add(new DummyFlowComponent());
    }

    @Test
    public void afteraddThreeComponents_AllReturnsAllThree() throws Exception {
        FlowComponent[] components = addNComponents(3);

        assertListEquals(componentLocator.all(), components);
    }

    @Test
    public void afterAddingTheSameComponentTwice_OnlyContainsOneInstance() throws Exception {
        FlowComponent component = new DummyFlowComponent();

        componentLocator.add(component);
        componentLocator.add(component);

        assertListEquals(componentLocator.all(), component);
    }

    @Test
    public void afteraddComponent_AllReturnsOnlyThatComponent() throws Exception {
        DummyFlowComponent component = new DummyFlowComponent();
        componentLocator.add(component);

        List<FlowComponent> all = componentLocator.all();

        assertListEquals(all, component);
    }

    @Test
    public void filterWithoutSpecifyingFilters_ReturnsAll() throws Exception {
        FlowComponent[] components = addNComponents(3);

        List<FlowComponent> filteredComponents = componentLocator.filter();

        assertListEquals(filteredComponents, components);
    }

    @Test
    public void canFilter() throws Exception {
        FlowComponent[] components = addNComponents(3);

        FlowComponent[] expectedComponents = new FlowComponent[] {components[0], components[2]};
        final FlowComponent filteredComponent = components[1];

        List<FlowComponent> filteredComponents = componentLocator.filter(new ComponentFilter() {
            public boolean test(FlowComponent c) {
                return c != filteredComponent;
            }
        });

        assertListEquals(filteredComponents, expectedComponents);
    }
}