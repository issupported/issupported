INSERT INTO public.attribute (id, name) VALUES (1, 'border-radius');
INSERT INTO public.attribute (id, name) VALUES (2, 'cursor');

INSERT INTO public.browser (id, name, version) VALUES (1, 'Chrome', '49');
INSERT INTO public.browser (id, name, version) VALUES (2, 'Chrome', '51');
INSERT INTO public.browser (id, name, version) VALUES (3, 'Chrome', '52');
INSERT INTO public.browser (id, name, version) VALUES (4, 'IE', '8');
INSERT INTO public.browser (id, name, version) VALUES (5, 'IE', '11');


INSERT INTO public.browser_to_attribute (browser_id, attribute_id, supported_status) VALUES (1, 1, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, supported_status) VALUES (2, 1, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, supported_status) VALUES (3, 1, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, supported_status) VALUES (1, 2, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, supported_status) VALUES (2, 2, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, supported_status) VALUES (3, 2, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, supported_status) VALUES (4, 2, 'PARTIAL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, supported_status) VALUES (5, 1, 'NOT');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, supported_status) VALUES (4, 1, 'FULL');
INSERT INTO public.browser_to_attribute (browser_id, attribute_id, supported_status) VALUES (5, 2, 'FULL');